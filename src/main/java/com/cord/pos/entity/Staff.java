package com.cord.pos.entity;

import com.cord.pos.enums.Role;
import com.cord.pos.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "staff_tbl")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Staff {

    @Id
    @SequenceGenerator(sequenceName = "tbl_staff_id_seq", initialValue = 1, allocationSize = 1, name ="tbl_staff_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_staff_id_seq")
    private long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "join_date")
    private LocalDate joinDate;

}
