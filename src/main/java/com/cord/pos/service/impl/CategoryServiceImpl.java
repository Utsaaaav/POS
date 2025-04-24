package com.cord.pos.service.impl;

import com.cord.pos.dto.category.CategoryRequestDTO;
import com.cord.pos.dto.category.CategoryResponseDTO;
import com.cord.pos.entity.Category;
import com.cord.pos.repository.CategoryRepo;
import com.cord.pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {

        Category category = Category.builder()
                .categoryName(categoryRequestDTO.getCategoryName())
                .build();

        categoryRepo.save(category);

        CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.builder()
                .id(category.getId())
                .categoryName(categoryRequestDTO.getCategoryName())
                .build();

        return categoryResponseDTO;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategory() {
        return List.of();
    }

    @Override
    public void deleteCategory(long id) {

    }

    @Override
    public CategoryResponseDTO updateCategory(long id, CategoryRequestDTO categoryRequestDTO) {
        return null;
    }
}
