package com.RestaurantChooser.dao;

import com.RestaurantChooser.model.MenuItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcMenuItemDao implements MenuItemDao {

    @Override
    public MenuItem getMenuItem() {
        return null;
    }

    @Override
    public List<MenuItem> listMenuItems() {
        return null;
    }

    @Override
    public void updateMenuItem() {
    }

    @Override
    public void deleteMenuItem() {
    }
}
