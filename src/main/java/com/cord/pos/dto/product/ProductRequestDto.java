package com.cord.pos.dto.product;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDto {

    private String name;
    private String price;
    private String taxRate;

}
