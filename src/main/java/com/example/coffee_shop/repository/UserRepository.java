package com.example.coffee_shop.repository;

import com.example.coffee_shop.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsernameAndPassword(String username,String password);

    UserEntity findByUsernameAndPassword(String username,String password);

    UserEntity findByUsername(String username);
}
