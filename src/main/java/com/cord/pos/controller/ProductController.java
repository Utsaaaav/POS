package com.cord.pos.controller;

import com.cord.pos.dto.GlobalApiResponse;
import com.cord.pos.dto.product.ProductRequestPojo;
import com.cord.pos.dto.product.ProductResponsePojo;
import com.cord.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController extends BaseController{

    private final ProductService productService;

    @PostMapping("/create-product")
    public ResponseEntity<GlobalApiResponse> create(@RequestBody ProductRequestPojo productRequestPojo){

        try{
            ProductResponsePojo productResponsePojo = productService.createProduct(productRequestPojo);
            return new ResponseEntity<>(successResponse("Product Created Successfully.", productResponsePojo), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-products")
    public ResponseEntity<GlobalApiResponse> list(){

        try{
            List<ProductResponsePojo> products = productService.findAllProduct();
            return new ResponseEntity<>(successResponse("Product Listed Successfully.", products),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-products/{id}")
    public ResponseEntity<GlobalApiResponse> deleteProduct(@PathVariable long id){

        productService.deleteProduct(id);
        return new ResponseEntity<>(successResponse("Product deleted successfully.", id),HttpStatus.OK);

    }

    @PutMapping("/update-products/{id}")
    public ResponseEntity<GlobalApiResponse> updateProduct(@PathVariable long id, @RequestBody ProductRequestPojo productRequestPojo){

        ProductResponsePojo productResponsePojo = productService.updateProduct(id, productRequestPojo);
        return new ResponseEntity<>(successResponse("Product Updated Successfully", productResponsePojo), HttpStatus.OK);

    }

}
