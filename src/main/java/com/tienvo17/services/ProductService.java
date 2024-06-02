package com.tienvo17.services;

import com.tienvo17.models.Category;
import com.tienvo17.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Boolean create(Product product);
    Category findById(int id);
    Boolean update(Product product);
    Boolean delete(int id);
}
