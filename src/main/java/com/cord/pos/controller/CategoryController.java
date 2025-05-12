package com.cord.pos.controller;

import com.cord.pos.dto.GlobalApiResponse;
import com.cord.pos.dto.category.CategoryRequestPojo;
import com.cord.pos.dto.category.CategoryResponsePojo;
import com.cord.pos.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor

public class CategoryController extends BaseController{

    private final CategoryService categoryService;

    @PostMapping("/create-category")
    public ResponseEntity<GlobalApiResponse> createCategory(@RequestBody CategoryRequestPojo categoryRequestPojo){

        try {
            CategoryResponsePojo categoryResponsePojo = categoryService.createCategory(categoryRequestPojo);
            return new ResponseEntity<>(successResponse("Category Added Successfully", categoryResponsePojo), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-category")
    public ResponseEntity<GlobalApiResponse> listCategory(){
        try{
            List<CategoryResponsePojo> category = categoryService.getAllCategory();
            return new ResponseEntity<>(successResponse("Category Listed Sucessfully",category),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<GlobalApiResponse> deleteCategory(@PathVariable long id){

        categoryService.deleteCategory(id);
        return new ResponseEntity<>(successResponse("Category Deleted Successfully", id),HttpStatus.OK);

    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<GlobalApiResponse> updateCategory(@PathVariable long id, @RequestBody CategoryRequestPojo categoryRequestPojo){

       CategoryResponsePojo category  = categoryService.updateCategory(id, categoryRequestPojo);
       return new ResponseEntity<>(successResponse("Category Updated Successfully", category),HttpStatus.OK);

    }









}
