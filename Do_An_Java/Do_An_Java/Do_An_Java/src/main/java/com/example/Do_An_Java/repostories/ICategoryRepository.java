package com.example.Do_An_Java.repostories;

import com.example.Do_An_Java.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends
        JpaRepository<Category, Long> {
}