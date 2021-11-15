package com.RestaurantChooser.dao;

import com.RestaurantChooser.model.MenuItem;

import java.util.List;

public interface MenuItemDao {

    MenuItem getMenuItem();

    List<MenuItem> listMenuItems();

    void updateMenuItem();

    void deleteMenuItem();
}
