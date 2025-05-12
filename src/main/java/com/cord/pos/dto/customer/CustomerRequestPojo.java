package com.cord.pos.dto.customer;

import com.cord.pos.enums.CustomerType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequestPojo {

    private String fullName;
    private String email;
    private String phone;
    private String initialDiscount;
    private CustomerType customerType;



}
