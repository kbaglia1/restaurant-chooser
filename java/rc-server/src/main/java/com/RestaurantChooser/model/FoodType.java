package com.RestaurantChooser.model;

public class FoodType {

    private long id;
    private String name;

    public FoodType(){
    }

    public FoodType(String name){
        this.name = name;
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

}
