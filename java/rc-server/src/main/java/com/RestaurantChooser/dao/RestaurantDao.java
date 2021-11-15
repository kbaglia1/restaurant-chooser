package com.RestaurantChooser.dao;

import com.RestaurantChooser.model.Restaurant;

import java.util.List;

public interface RestaurantDao {

    Restaurant getRestaurantById(long id);

    Restaurant getRandomRestaurant();

    List<Restaurant> listRestaurants();

    List<Restaurant> listRestaurantsByFoodType(long foodTypeId);

    List<Restaurant> searchRestaurantsByName(String nameSearch);

    Restaurant addRestaurant(Restaurant restaurant);

    boolean assignFoodType(long restaurantId, long foodTypeId);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(long restaurantId);
}
