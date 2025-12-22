package edu.rsm.service;

import edu.rsm.dto.MenuItem;

import java.util.List;

public interface MenuItemService {
    void save(MenuItem menuItem);

    List<MenuItem> getAll();

    MenuItem getById(String id);

    void updateById(String menuItemId, MenuItem menuItem);

    void deletById(String id);
}
