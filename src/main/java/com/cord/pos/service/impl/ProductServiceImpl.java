package com.cord.pos.service.impl;

import com.cord.pos.dto.product.ProductRequestPojo;
import com.cord.pos.dto.product.ProductResponsePojo;
import com.cord.pos.entity.Category;
import com.cord.pos.entity.Product;
import com.cord.pos.repository.CategoryRepo;
import com.cord.pos.repository.ProductRepo;
import com.cord.pos.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

    private final ProductRepo productRepo;

    private final CategoryRepo categoryRepo;

    @Override
    public ProductResponsePojo createProduct(ProductRequestPojo productRequestPojo) {


        Category category = categoryRepo.findByCategoryName(productRequestPojo.getCategoryName());

        if(category == null){
            category = categoryRepo.findByCategoryName("Uncategorized");
            if(category == null){
                category = Category.builder()
                        .categoryName("Uncategorized")
                        .build();
            }
            categoryRepo.save(category);
//            throw new RuntimeException("Category not found with name " + productRequestDto.getCategoryName());

        }

        Product product = Product.builder()
                .name(productRequestPojo.getName())
                .category(category)
                .price(productRequestPojo.getPrice())
                .taxRate(productRequestPojo.getTaxRate())
                .build();
        productRepo.save(product);

        ProductResponsePojo productResponsePojo = ProductResponsePojo.builder()
                .id(product.getId())
                .name(product.getName())
                .categoryName(category.getCategoryName())
                .price(product.getPrice())
                .taxRate(product.getTaxRate())
                .build();

        return productResponsePojo;
    }

    @Override
    public List<ProductResponsePojo> findAllProduct() {

        List<Product> product = productRepo.findAll();
        List<ProductResponsePojo> productResponsePojo = new ArrayList<>();
        for(Product p: product){

            ProductResponsePojo productResponsedto = ProductResponsePojo.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .categoryName(p.getCategory().getCategoryName())
                    .price(p.getPrice())
                    .taxRate(p.getTaxRate())
                    .build();

            productResponsePojo.add(productResponsedto);
        }
        return productResponsePojo;
    }

    @Override
    public void deleteProduct(long id) {

        Product products = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id "+id));
        productRepo.delete(products);

    }

    @Override
    public ProductResponsePojo updateProduct(long id, ProductRequestPojo productRequestPojo) {

        Product existingProduct = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id "+ id));

        Category category = categoryRepo.findByCategoryName(productRequestPojo.getCategoryName());
        if(category == null ){
            throw new RuntimeException("Category not found");
        }

        existingProduct.setName(productRequestPojo.getName());
        existingProduct.setCategory(categoryRepo.findByCategoryName(productRequestPojo.getCategoryName()));
        existingProduct.setPrice(productRequestPojo.getPrice());
        existingProduct.setTaxRate(productRequestPojo.getTaxRate());

        productRepo.save(existingProduct);

        ProductResponsePojo productResponsePojo = ProductResponsePojo.builder()
                .id(existingProduct.getId())
                .name(productRequestPojo.getName())
                .categoryName(existingProduct.getCategory().getCategoryName())
                .price(productRequestPojo.getPrice())
                .taxRate(productRequestPojo.getTaxRate())
                .build();

        return productResponsePojo;
   }
}
