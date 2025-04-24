package com.cord.pos.dto.customer;

import com.cord.pos.enums.CustomerType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CustomerResponseDTO {

    private long id;
    private String fullName;
    private String email;
    private String phone;
    private String initialDiscount;
    private CustomerType customerType;

}
