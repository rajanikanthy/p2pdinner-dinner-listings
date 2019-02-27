package com.p2pdinner.domain;

import com.p2pdinner.proto.MenuItem;

import java.util.function.Function;

public class MenuItemToDinnerListingTransformation implements Function<MenuItem, DinnerListing> {

    @Override
    public DinnerListing apply(MenuItem menuItem) {
        DinnerListing listing = new DinnerListing();
        listing.setId(menuItem.getId());
        listing.setProfileId(menuItem.getProfileId());
        listing.setTitle(menuItem.getTitle());
        listing.setAddressLine1(menuItem.getAddressLine1());
        listing.setAddressLine2(menuItem.getAddressLine2());
        listing.setAvailableQuantity(menuItem.getAvailableQuantity());
        listing.setStartTime(new java.sql.Timestamp(menuItem.getStartDate()));
        listing.setEndTime(new java.sql.Timestamp(menuItem.getEndDate()));
        listing.setCloseTime(new java.sql.Timestamp(menuItem.getCloseDate()));
        listing.setCity(listing.getCity());
        listing.setZipCode(listing.getZipCode());
        listing.setState(listing.getState());
        if (menuItem.getSpecialNeedsCount() != 0) {
            listing.setSpecialNeeds(menuItem.getSpecialNeedsList());
        }
        if (menuItem.getDeliveriesCount() != 0) {
            listing.setDeliveryTypes(menuItem.getDeliveriesList());
        }
        if (menuItem.getCategoriesCount() != 0) {
            listing.setCategories(menuItem.getCategoriesList());
        }
        return listing;
    }
}
