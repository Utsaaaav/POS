package com.cord.pos.service.impl;

import com.cord.pos.dto.category.CategoryRequestDTO;
import com.cord.pos.dto.category.CategoryResponseDTO;
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
        List<Category> categories = categoryRepo.findAll();
        List<CategoryResponseDTO> categoryResponseDTO = new ArrayList<>();
        for(Category c : categories){

            CategoryResponseDTO categoryResponsedto = CategoryResponseDTO.builder()
                    .id(c.getId())
                    .categoryName(c.getCategoryName())
                    .productCount(c.getProducts().size())
                    .build();

            categoryResponseDTO.add(categoryResponsedto);
        }

        return categoryResponseDTO;

    }

    @Override
    public void deleteCategory(long id) {

        Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Catagory not found with id " +id));
        categoryRepo.delete(category);

    }

    @Override
    public CategoryResponseDTO updateCategory(long id, CategoryRequestDTO categoryRequestDTO) {

       Category exCategory = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category not found with id "+id));
       exCategory.setCategoryName(categoryRequestDTO.getCategoryName());

       categoryRepo.save(exCategory);

       CategoryResponseDTO categoryResponseDTO = CategoryResponseDTO.builder()
               .id(exCategory.getId())
               .categoryName(categoryRequestDTO.getCategoryName())
               .build();

        return categoryResponseDTO;
    }
}
