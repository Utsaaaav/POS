package com.cord.pos.dto.product;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestPojo {

    private String name;
    private String categoryName;
    private String price;
    private String taxRate;

}
