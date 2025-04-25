package com.cord.pos.dto.product;

import com.cord.pos.entity.Category;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponseDTO {

    private long id;
    private String name;
    private String categoryName;
    private String price;
    private String taxRate;


}
