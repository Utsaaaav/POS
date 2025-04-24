package com.cord.pos.controller;

import com.cord.pos.dto.GlobalApiResponse;
import com.cord.pos.dto.product.ProductRequestDto;
import com.cord.pos.dto.product.ProductResponseDTO;
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
    public ResponseEntity<GlobalApiResponse> create(@RequestBody ProductRequestDto productRequestDto){

        try{
            ProductResponseDTO productResponseDTO = productService.createProduct(productRequestDto);
            return new ResponseEntity<>(successResponse("Product Created Successfully.", productResponseDTO), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-products")
    public ResponseEntity<GlobalApiResponse> list(){

        try{
            List<ProductResponseDTO> products = productService.findAllProduct();
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
    public ResponseEntity<GlobalApiResponse> updateProduct(@PathVariable long id, @RequestBody ProductRequestDto productRequestDto){

        ProductResponseDTO productResponseDTO = productService.updateProduct(id, productRequestDto);
        return new ResponseEntity<>(successResponse("Product Updated Successfully", productResponseDTO), HttpStatus.OK);

    }

}
