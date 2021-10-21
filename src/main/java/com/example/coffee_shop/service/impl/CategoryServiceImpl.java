package com.example.coffee_shop.service.impl;

import com.example.coffee_shop.model.entity.Category;
import com.example.coffee_shop.model.enums.CategoryEnum;
import com.example.coffee_shop.repository.CategoryRepository;
import com.example.coffee_shop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public boolean checkIfDBIsempty() {
        return this.categoryRepository.count() == 0;
    }

    @Override
    public Set<String> findCategoryNames() {
        return this.categoryRepository.findCategoryNames();
    }

    @Override
    public Category findCategoryByName(String category) {
        if (category.equalsIgnoreCase("category")) {
            throw new IllegalArgumentException("try again");
        }
        return this.categoryRepository.findByCategoryEnum(CategoryEnum.valueOf(category));
    }
}
