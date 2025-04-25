package com.cord.pos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories_tbl")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Category {

    @Id
    @SequenceGenerator(name = "tbl_categories_id_seq", initialValue = 1, allocationSize = 1, sequenceName = "tbl_categories_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_categories_id_seq")
    private long id;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;

}
