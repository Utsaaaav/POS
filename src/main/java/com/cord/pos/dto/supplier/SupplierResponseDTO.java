package com.cord.pos.dto.supplier;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SupplierResponseDTO {

    private long id;
    private String supplierName;
    private String contactPerson;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;

}
