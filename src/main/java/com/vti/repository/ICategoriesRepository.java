package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Categories;

public interface ICategoriesRepository extends JpaRepository<Categories, Long> {
    public List<Categories> getAllCategories();
}
