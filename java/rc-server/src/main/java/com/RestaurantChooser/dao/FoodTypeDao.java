package com.RestaurantChooser.dao;

import com.RestaurantChooser.model.FoodType;

import java.util.List;

public interface FoodTypeDao {

    FoodType getFoodType();

    List<FoodType> listFoodTypes();

    void updateFoodType();

    void deleteFoodType();
}
