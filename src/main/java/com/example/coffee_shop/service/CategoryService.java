package com.example.coffee_shop.service;

import com.example.coffee_shop.model.entity.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void initCategories(List<Category> categories);

    boolean checkIfDBIsempty();

    Set<String> findCategoryNames();

    Category findCategoryByName(String category);
}
