package com.RestaurantChooser.model;

public class MenuItem {

    private long id;
    private String name;
    private long restaurant_id;

    public MenuItem(){
    }

    public MenuItem(String name, long restaurant_id) {
        this.name = name;
        this.restaurant_id = restaurant_id;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getRestaurant_id() {
        return restaurant_id;
    }
    public void setRestaurant_id(long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

}
