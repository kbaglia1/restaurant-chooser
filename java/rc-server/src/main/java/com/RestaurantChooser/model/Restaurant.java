package com.RestaurantChooser.model;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Restaurant {

    @NotBlank(message = "Restaurant ID cannot be blank")
    private long id;
    @NotBlank(message = "Restaurant name cannot be blank")
    private String name;
    @NotBlank(message = "Restaurant price point cannot be blank")
    @Min(value = 1, message = "Restaurant price point must be an integer between 1 and 5")
    @Max(value = 5, message = "Restaurant price point must be an integer between 1 and 5")
    private int pricePoint;
    private boolean hasSeating;
    private boolean hasDriveThru;
    private boolean hasOnlineOrdering;

    public Restaurant(){
    }

    public Restaurant(String name, String foodType, int pricePoint) {
        this.name = name;
        this.pricePoint = pricePoint;
    }

    public Restaurant(String name, String foodType, int pricePoint, boolean hasSeating,
                      boolean hasDriveThru, boolean hasOnlineOrdering) {
        this.name = name;
        this.pricePoint = pricePoint;
        this.hasSeating = hasSeating;
        this.hasDriveThru = hasDriveThru;
        this.hasOnlineOrdering = hasOnlineOrdering;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getPricePoint() {
        return pricePoint;
    }
    public boolean isHasSeating() {
        return hasSeating;
    }
    public boolean isHasDriveThru() {
        return hasDriveThru;
    }
    public boolean isHasOnlineOrdering() {
        return hasOnlineOrdering;
    }
    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPricePoint(int pricePoint) {
        this.pricePoint = pricePoint;
    }
    public void setHasSeating(boolean hasSeating) {
        this.hasSeating = hasSeating;
    }
    public void setHasDriveThru(boolean hasDriveThru) {
        this.hasDriveThru = hasDriveThru;
    }
    public void setHasOnlineOrdering(boolean hasOnlineOrdering) {
        this.hasOnlineOrdering = hasOnlineOrdering;
    }


    @Override
    public String toString() {
        return String.format("Name: %s\nPrice Point (1-5): %d",
                this.name, this.pricePoint);
    }
}
