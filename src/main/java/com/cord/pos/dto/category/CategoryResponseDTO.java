package com.cord.pos.dto.category;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponseDTO {

    private long id;
    private String categoryName;

}
