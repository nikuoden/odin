package com.odin.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.odin.api.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}