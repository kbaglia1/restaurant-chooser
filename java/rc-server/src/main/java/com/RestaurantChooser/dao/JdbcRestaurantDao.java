package com.RestaurantChooser.dao;

import com.RestaurantChooser.model.Restaurant;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcRestaurantDao implements RestaurantDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcRestaurantDao(DataSource dataSource) {
        this.jdbcTemplate =  new JdbcTemplate(dataSource);
    }

    @Override
    public Restaurant getRestaurantById(long id) {
        Restaurant restaurant = new Restaurant();
        String sql = "SELECT * FROM restaurant " +
                "WHERE id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            restaurant = mapRowToRestaurant(results);
        }
        return restaurant;
    }

    @Override
    public Restaurant getRandomRestaurant() {
        Restaurant restaurant = new Restaurant();
        String sql = "SELECT * FROM restaurant " +
                "ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
           restaurant = mapRowToRestaurant(results);
        }
        return restaurant;
    }

    @Override
    public List<Restaurant> listRestaurants() {
        List<Restaurant> restaurantList = new ArrayList<>();
        String sql = "SELECT * FROM restaurant " +
                "ORDER BY name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurant(results));
        }
        return restaurantList;
    }

    @Override
    public List<Restaurant> listRestaurantsByFoodType(long foodTypeId) {
        List<Restaurant> restaurantList = new ArrayList<>();
        String sql = "SELECT * FROM restaurant " +
                "JOIN restaurant_food_type ON restaurant.id = restaurant_food_type.restaurant_id " +
                "WHERE food_type_id = ? ORDER BY name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, foodTypeId);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurant(results));
        }
        return restaurantList;
    }

    @Override
    public List<Restaurant> searchRestaurantsByName(String name) {
        List<Restaurant> restaurantList = new ArrayList<>();
        String sql = "SELECT * FROM restaurant " +
                "WHERE name ILIKE concat('%', ?, '%') ORDER BY name;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, name);
        while (results.next()) {
            restaurantList.add(mapRowToRestaurant(results));
        }
        return restaurantList;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant (id, name, price_point, has_seating, has_drive_thru, has_online_ordering) " +
                "VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
        Long newId = null;
        try {
            newId = jdbcTemplate.queryForObject(sql, Long.class, restaurant.getId(), restaurant.getName(),
                    restaurant.getPricePoint(), restaurant.isHasSeating(), restaurant.isHasDriveThru(), restaurant.isHasOnlineOrdering());
        } catch (DataAccessException e) {
            System.out.println("An error occurred. Please retry with valid info.");
        }

        return getRestaurantById(newId);
    }

    @Override
    public boolean assignFoodType(long restaurantId, long foodTypeId) {
        return false;
    }


    @Override
    public void updateRestaurant(Restaurant updatedRestaurant) {
        String sql = "UPDATE restaurant SET (name = ?, price_point =?, has_seating = ?, " +
                "has_drive_thru = ?, has_online_ordering = ?) " +
                "WHERE id = ?;";
        try {
            jdbcTemplate.update(sql, updatedRestaurant.getName(), updatedRestaurant.getPricePoint(),
                    updatedRestaurant.isHasSeating(), updatedRestaurant.isHasDriveThru(),
                    updatedRestaurant.isHasOnlineOrdering(), updatedRestaurant.getId());
        } catch (DataAccessException e) {
            System.out.println("An error occurred. Please retry with valid info.");
        }
    }

    @Override
    public void deleteRestaurant(long restaurantId) {
        String sql = "DELETE FROM menu_item WHERE restaurant_id = ?; " +
                "DELETE FROM restaurant_food_type WHERE restaurant_id = ?;" +
                "DELETE FROM restaurant WHERE id = ?;";
        jdbcTemplate.update(sql, restaurantId, restaurantId, restaurantId);
    }

    private Restaurant mapRowToRestaurant(SqlRowSet rowSet) {
        Restaurant restaurant = new Restaurant();
        restaurant.setId(rowSet.getLong("id"));
        restaurant.setName(rowSet.getString("name"));
        restaurant.setPricePoint(rowSet.getInt("price_point"));
        restaurant.setHasSeating(rowSet.getBoolean("has_seating"));
        restaurant.setHasDriveThru(rowSet.getBoolean("has_drive_thru"));
        restaurant.setHasOnlineOrdering(rowSet.getBoolean("has_online_ordering"));
        return restaurant;
    }
}
