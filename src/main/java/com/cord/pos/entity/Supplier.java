package com.cord.pos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "supplier_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Supplier {

    @Id
    @SequenceGenerator(name = "tbl_supplier_id_seq" , initialValue = 1, allocationSize = 0, sequenceName = "tbl_supplier_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_supplier_id_seq")
    @Column(name = "supplier_id")
    private long id;

    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "contact_person")
    private String contactPerson;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

}
