package com.example.coffee_shop;

import com.example.coffee_shop.model.entity.Category;
import com.example.coffee_shop.model.enums.CategoryEnum;
import com.example.coffee_shop.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final CategoryService categoryService;

    public DBInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.categoryService.checkIfDBIsempty()) {

            Category coffee = new Category();
            coffee.setCategoryEnum(CategoryEnum.COFFEE);

            Category drink = new Category();
            drink.setCategoryEnum(CategoryEnum.DRINK);

            Category cake = new Category();
            cake.setCategoryEnum(CategoryEnum.CAKE);

            Category other = new Category();
            other.setCategoryEnum(CategoryEnum.OTHER);

            this.categoryService.initCategories(List.of(coffee, drink, cake, other));

        }
    }
}
