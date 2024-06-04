package com.tienvo17.services;

import com.tienvo17.models.Category;
import com.tienvo17.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Boolean create(Category category) {
        try{
            this.categoryRepository.save(category);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Category findById(int id) {
        return this.categoryRepository.findById(id).get();
    }

    @Override
    public Boolean update(Category category) {
        try{
            this.categoryRepository.save(category);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(int id) {
        try{
             this.categoryRepository.deleteById(id);
             return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Category> searchCategory(String kw) {
        return this.categoryRepository.searchCategory(kw);
    }

    @Override
    public Page<Category> getAll(int pageNo) {
        Pageable pageable = PageRequest.of(pageNo-1,3);
        return this.categoryRepository.findAll(pageable);
    }
}
