package com.cord.pos.service;

import com.cord.pos.dto.category.CategoryRequestPojo;
import com.cord.pos.dto.category.CategoryResponsePojo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {

    CategoryResponsePojo createCategory(CategoryRequestPojo categoryRequestPojo);

    List<CategoryResponsePojo> getAllCategory();

    void deleteCategory(long id);

    CategoryResponsePojo updateCategory(long id, CategoryRequestPojo categoryRequestPojo);

}
