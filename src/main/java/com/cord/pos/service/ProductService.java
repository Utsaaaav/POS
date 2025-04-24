package com.cord.pos.service;

import com.cord.pos.dto.product.ProductRequestDto;
import com.cord.pos.dto.product.ProductResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    ProductResponseDTO createProduct(ProductRequestDto productRequestDto);

    List<ProductResponseDTO> findAllProduct();

    void deleteProduct(long id);

    ProductResponseDTO updateProduct(long id, ProductRequestDto productRequestDTO);

}
