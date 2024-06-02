package com.tienvo17.services;

import com.tienvo17.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    Boolean create(Category category);
    Category findById(int id);
    Boolean update(Category category);
    Boolean delete(int id);
}
