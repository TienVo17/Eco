package com.tienvo17.services;

import com.tienvo17.models.Category;
import com.tienvo17.models.Product;
import com.tienvo17.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Boolean create(Product product) {
        try{
            this.productRepository.save(product);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        return this.productRepository.findById(id).get();
    }

    @Override
    public Boolean update(Product product) {
        try{
            this.productRepository.save(product);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }
}
