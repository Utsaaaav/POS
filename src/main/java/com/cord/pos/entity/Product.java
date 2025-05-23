package com.cord.pos.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product_tbl")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class Product {

    @Id
    @SequenceGenerator(name = "tbl_product_id_name", allocationSize = 1,initialValue = 1, sequenceName ="tbl_product_id_name")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_product_id_name")
    @Column(name = "product_id")
    private long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_price")
    private String price;

    @Column(name = "tax_rate")
    private String taxRate;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Category.class)
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_PRODUCT_CATEGORY"))
    private Category category;

}
