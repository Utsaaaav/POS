package com.cord.pos.service.impl;

import com.cord.pos.dto.category.CategoryRequestPojo;
import com.cord.pos.dto.category.CategoryResponsePojo;
import com.cord.pos.entity.Category;
import com.cord.pos.repository.CategoryRepo;
import com.cord.pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public CategoryResponsePojo createCategory(CategoryRequestPojo categoryRequestPojo) {

        Category category = Category.builder()
                .categoryName(categoryRequestPojo.getCategoryName())
                .build();

        categoryRepo.save(category);

        CategoryResponsePojo categoryResponsePojo = CategoryResponsePojo.builder()
                .id(category.getId())
                .categoryName(categoryRequestPojo.getCategoryName())
                .build();

        return categoryResponsePojo;
    }

    @Override
    public List<CategoryResponsePojo> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryResponsePojo> categoryResponsePojo = new ArrayList<>();
        for(Category c : categories){

            CategoryResponsePojo categoryResponsedto = CategoryResponsePojo.builder()
                    .id(c.getId())
                    .categoryName(c.getCategoryName())
                    .productCount(c.getProducts().size())
                    .build();

            categoryResponsePojo.add(categoryResponsedto);
        }

        return categoryResponsePojo;

    }

    @Override
    public void deleteCategory(long id) {

        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Catagory not found with id " +id));
        categoryRepo.delete(category);

    }

    @Override
    public CategoryResponsePojo updateCategory(long id, CategoryRequestPojo categoryRequestPojo) {

       Category exCategory = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id "+id));
       exCategory.setCategoryName(categoryRequestPojo.getCategoryName());

       categoryRepo.save(exCategory);

       CategoryResponsePojo categoryResponsePojo = CategoryResponsePojo.builder()
               .id(exCategory.getId())
               .categoryName(categoryRequestPojo.getCategoryName())
               .build();

        return categoryResponsePojo;
    }
}
