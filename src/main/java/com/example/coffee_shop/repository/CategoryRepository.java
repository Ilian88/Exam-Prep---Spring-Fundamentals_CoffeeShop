package com.example.coffee_shop.repository;

import com.example.coffee_shop.model.entity.Category;
import com.example.coffee_shop.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    @Query("SELECT c.categoryEnum FROM Category c ORDER BY c.categoryEnum")
    Set<String> findCategoryNames();

    Category findByCategoryEnum(CategoryEnum categoryEnum);
}
