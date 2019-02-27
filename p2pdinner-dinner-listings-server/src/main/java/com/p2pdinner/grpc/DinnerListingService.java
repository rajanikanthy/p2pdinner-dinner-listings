package com.p2pdinner.grpc;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.p2pdinner.domain.DinnerListing;
import com.p2pdinner.domain.MenuItemToDinnerListingTransformation;
import com.p2pdinner.proto.DinnerListingsServiceGrpc;
import com.p2pdinner.proto.ListingResponse;
import com.p2pdinner.proto.MenuItem;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.function.Function;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@GRpcService
public class DinnerListingService extends DinnerListingsServiceGrpc.DinnerListingsServiceImplBase {

    private static final Logger logger = LoggerFactory.getLogger(DinnerListingService.class);

    private final MongoTemplate mongoTemplate;

    @Autowired
    public DinnerListingService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void addDinnerListing(MenuItem request, StreamObserver<ListingResponse> responseObserver) {
        logger.info("DinnerListingService >> addDinnerListing >>  {}", request.getTitle());
        DinnerListing listing = new MenuItemToDinnerListingTransformation().apply(request);
        mongoTemplate.insert(listing, "listing");
        ListingResponse response = ListingResponse.newBuilder()
                .setSuccess(true)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void updateDinnerListing(MenuItem request, StreamObserver<ListingResponse> responseObserver) {
        logger.info("DinnerListingService >> updateDinnerListing >> {}", request.getTitle());
        DinnerListing listing = new MenuItemToDinnerListingTransformation().apply(request);
        UpdateResult result = mongoTemplate.updateFirst(query(where("_id")
                        .is(listing.getId())
                        .andOperator()
                        .where("profileId")
                        .is(listing.getProfileId())),
                Update.update("startTime", listing.getStartTime()).set("endTime", listing.getEndTime()).set("closeTime", listing.getCloseTime()),
                DinnerListing.class
        );

        responseObserver.onNext(ListingResponse.newBuilder().setSuccess(result.wasAcknowledged()).build());
        responseObserver.onCompleted();
    }

    @Override
    public void deleteDinnerListing(MenuItem request, StreamObserver<ListingResponse> responseObserver) {
        logger.info("DinnerListingService >> deleteDinnerListing >> {}", request.getTitle());
        DeleteResult result = mongoTemplate.remove(query(where("_id")
                .is(request.getId())
                .andOperator(where("profileId").is(request.getProfileId()))));

        responseObserver.onNext(ListingResponse.newBuilder().setSuccess(result.wasAcknowledged()).build());
        responseObserver.onCompleted();
    }
}
