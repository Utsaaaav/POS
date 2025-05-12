package com.cord.pos.dto.category;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponsePojo {

    private long id;
    private String categoryName;
    private int productCount;

}
