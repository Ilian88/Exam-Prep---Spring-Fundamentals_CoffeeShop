package com.example.coffee_shop.model.entity;

import com.example.coffee_shop.model.enums.CategoryEnum;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryEnum categoryEnum;

    private Integer neededTime;

    public Category() {
    }

    public Integer getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(Integer neededTime) {

        return this;
    }

    @Enumerated(EnumType.STRING)
    public CategoryEnum getCategoryEnum() {
        return categoryEnum;
    }

    public Category setCategoryEnum(CategoryEnum categoryEnum) {

        this.categoryEnum = categoryEnum;

        if (this.categoryEnum == CategoryEnum.COFFEE) {
            this.neededTime = 2;
        } else if (this.categoryEnum == CategoryEnum.DRINK) {
            this.neededTime = 1;
        } else if (this.categoryEnum == CategoryEnum.CAKE) {
            this.neededTime = 10;
        } else if (this.categoryEnum == CategoryEnum.OTHER) {
            this.neededTime = 5;
        }

        return this;
    }
}
