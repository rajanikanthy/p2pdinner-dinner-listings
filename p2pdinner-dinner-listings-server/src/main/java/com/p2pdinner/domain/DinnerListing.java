package com.p2pdinner.domain;


import com.p2pdinner.proto.MenuItem;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Document(collection = "listing")
public class DinnerListing implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private Integer profileId;

    private java.sql.Timestamp startTime;

    private java.sql.Timestamp endTime;

    private java.sql.Timestamp closeTime;

    private Integer availableQuantity;

    private Integer orderQuantity = 0;

    private String title;

    private String description;

    private Double costPerItem;

    private String placeId;

    private Boolean marked;

    private String addressLine1;

    private String addressLine2;

    private String zipCode;

    private String state;

    private String city;

    private List<MenuItem.DinnerCategory> categories;
    private List<MenuItem.DinnerSpecialNeeds> specialNeeds;
    private List<MenuItem.DinnerDelivery> deliveryTypes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Timestamp closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCostPerItem() {
        return costPerItem;
    }

    public void setCostPerItem(Double costPerItem) {
        this.costPerItem = costPerItem;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public Boolean getMarked() {
        return marked;
    }

    public void setMarked(Boolean marked) {
        this.marked = marked;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<MenuItem.DinnerCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<MenuItem.DinnerCategory> categories) {
        this.categories = categories;
    }

    public List<MenuItem.DinnerSpecialNeeds> getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(List<MenuItem.DinnerSpecialNeeds> specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public List<MenuItem.DinnerDelivery> getDeliveryTypes() {
        return deliveryTypes;
    }

    public void setDeliveryTypes(List<MenuItem.DinnerDelivery> deliveryTypes) {
        this.deliveryTypes = deliveryTypes;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }
}
