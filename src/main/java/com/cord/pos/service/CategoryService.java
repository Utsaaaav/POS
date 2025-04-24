package com.cord.pos.service;

import com.cord.pos.dto.category.CategoryRequestDTO;
import com.cord.pos.dto.category.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> getAllCategory();

    void deleteCategory(long id);

    CategoryResponseDTO updateCategory(long id, CategoryRequestDTO categoryRequestDTO);

}
