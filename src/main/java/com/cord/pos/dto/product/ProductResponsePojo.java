package com.cord.pos.dto.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponsePojo {

    private long id;
    private String name;
    private String categoryName;
    private String price;
    private String taxRate;


}
