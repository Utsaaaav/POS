package com.cord.pos.entity;

import com.cord.pos.enums.CustomerType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "customer_tbl")

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Customer {

    @Id
    @SequenceGenerator(sequenceName = "tbl_customer_id_seq", allocationSize = 1, initialValue = 1, name = "tbl_customer_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tbl_customer_id_seq")
    @Column(name = "customer_id")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "initial_discount")
    private String initialDiscount;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type")
    private CustomerType customerType;

}
