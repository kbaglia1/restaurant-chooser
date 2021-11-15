package com.RestaurantChooser.dao;

import com.RestaurantChooser.model.FoodType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcFoodTypeDao implements FoodTypeDao {

    @Override
    public FoodType getFoodType() {
        return null;
    }

    @Override
    public List<FoodType> listFoodTypes() {
        return null;
    }

    @Override
    public void updateFoodType() {
    }

    @Override
    public void deleteFoodType() {
    }
}
