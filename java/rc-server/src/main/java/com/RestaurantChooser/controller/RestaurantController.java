package com.RestaurantChooser.controller;

import com.RestaurantChooser.dao.RestaurantDao;
import com.RestaurantChooser.model.Restaurant;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    private RestaurantDao restaurantDao;

    public RestaurantController(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Restaurant getById(@PathVariable long id) {
        return restaurantDao.getRestaurantById(id);
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public Restaurant getRandom() {
        return restaurantDao.getRandomRestaurant();
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Restaurant> listAll() {
        return restaurantDao.listRestaurants();
    }

    @RequestMapping(path = "/type/{foodTypeId}", method = RequestMethod.GET)
    public List<Restaurant> listByFoodType(@PathVariable long foodTypeId) {
        return restaurantDao.listRestaurantsByFoodType(foodTypeId);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public List<Restaurant> searchByName(@RequestParam String name) {
        List<Restaurant> restaurantList = new ArrayList<>();
        if (name != null) {
            restaurantList = (restaurantDao.searchRestaurantsByName(name));
        }
        return restaurantList;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Restaurant add(@Valid @RequestBody Restaurant restaurant) {
        return restaurantDao.addRestaurant(restaurant);
    }

    public void assignType() {
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@Valid @RequestBody Restaurant updatedRestaurant) {
        restaurantDao.updateRestaurant(updatedRestaurant);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        restaurantDao.deleteRestaurant(id);
    }

}
