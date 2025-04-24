package com.cord.pos.dto.product;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponseDTO {

    private long id;
    private String name;
    private String price;
    private String taxRate;

}
