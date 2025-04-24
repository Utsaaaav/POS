package com.cord.pos.service.impl;

import com.cord.pos.dto.product.ProductRequestDto;
import com.cord.pos.dto.product.ProductResponseDTO;
import com.cord.pos.entity.Product;
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

    @Override
    public ProductResponseDTO createProduct(ProductRequestDto productRequestDto) {

        Product product = Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .taxRate(productRequestDto.getTaxRate())
                .build();
        productRepo.save(product);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
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

        Product exProducts = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found with id "+ id));
        exProducts.setName(productRequestDTO.getName());
        exProducts.setPrice(productRequestDTO.getPrice());
        exProducts.setTaxRate(productRequestDTO.getTaxRate());

        productRepo.save(exProducts);

        ProductResponseDTO productResponseDTO = ProductResponseDTO.builder()
                .id(exProducts.getId())
                .name(productRequestDTO.getName())
                .price(productRequestDTO.getPrice())
                .taxRate(productRequestDTO.getTaxRate())
                .build();

        return productResponseDTO;
    }
}
