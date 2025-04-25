package com.cord.pos.service.impl;

import com.cord.pos.dto.product.ProductRequestDto;
import com.cord.pos.dto.product.ProductResponseDTO;
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
    public ProductResponseDTO createProduct(ProductRequestDto productRequestDto) {


        Category category = categoryRepo.findByCategoryName(productRequestDto.getCategoryName());

        if(category == null){

            throw new RuntimeException("Category not found with name " + productRequestDto.getCategoryName());

        }

        Product product = Product.builder()
                .name(productRequestDto.getName())
                .category(category)
                .price(productRequestDto.getPrice())
                .taxRate(productRequestDto.getTaxRate())
                .build();
        productRepo.save(product);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .categoryName(category.getCategoryName())
                .price(product.getPrice())
                .taxRate(product.getTaxRate())
                .build();

        return productResponseDTO;
    }

    @Override
    public List<ProductResponseDTO> findAllProduct() {

        List<Product> product = productRepo.findAll();
        List<ProductResponseDTO> productResponseDTO = new ArrayList<>();
        for(Product p: product){

            ProductResponseDTO productResponsedto = ProductResponseDTO.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .categoryName(p.getCategory().getCategoryName())
                    .price(p.getPrice())
                    .taxRate(p.getTaxRate())
                    .build();

            productResponseDTO.add(productResponsedto);
        }
        return productResponseDTO;
    }

    @Override
    public void deleteProduct(long id) {

        Product products = productRepo.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id "+id));
        productRepo.delete(products);

    }

    @Override
    public ProductResponseDTO updateProduct(long id, ProductRequestDto productRequestDTO) {

        Product existingProduct = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id "+ id));

        Category category = categoryRepo.findByCategoryName(productRequestDTO.getCategoryName());
        if(category == null){
            throw new RuntimeException("Category not found");
        }

        existingProduct.setName(productRequestDTO.getName());
        existingProduct.setCategory(categoryRepo.findByCategoryName(productRequestDTO.getCategoryName()));
        existingProduct.setPrice(productRequestDTO.getPrice());
        existingProduct.setTaxRate(productRequestDTO.getTaxRate());

        productRepo.save(existingProduct);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
                .id(existingProduct.getId())
                .name(productRequestDTO.getName())
                .categoryName(existingProduct.getCategory().getCategoryName())
                .price(productRequestDTO.getPrice())
                .taxRate(productRequestDTO.getTaxRate())
                .build();

        return productResponseDTO;
   }
}
