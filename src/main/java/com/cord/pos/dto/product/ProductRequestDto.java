package com.cord.pos.dto.product;

import com.cord.pos.entity.Category;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDto {

    private String name;
    private String categoryName;
    private String price;
    private String taxRate;

}
