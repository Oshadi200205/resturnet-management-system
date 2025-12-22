package edu.rsm.service;

import edu.rsm.dto.MenuCategory;

import java.util.List;

public interface MenuCategoryService {

    void save(MenuCategory menuCategory);

    List<MenuCategory> getAll();

    MenuCategory getById(String menuCategoryId);

    void deleteById(String menuCategoryId);

    MenuCategory updateById(String menuCategoryId, MenuCategory menuCategory);
}
