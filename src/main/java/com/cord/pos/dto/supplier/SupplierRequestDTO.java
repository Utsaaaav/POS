package com.cord.pos.dto.supplier;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SupplierRequestDTO {

    private String supplierName;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;

}
