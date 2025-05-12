package com.cord.pos.service;

import com.cord.pos.dto.product.ProductRequestPojo;
import com.cord.pos.dto.product.ProductResponsePojo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    ProductResponsePojo createProduct(ProductRequestPojo productRequestPojo);

    List<ProductResponsePojo> findAllProduct();

    void deleteProduct(long id);

    ProductResponsePojo updateProduct(long id, ProductRequestPojo productRequestPojo);

}
