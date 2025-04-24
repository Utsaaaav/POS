package com.cord.pos.dto.staff;

import com.cord.pos.enums.Role;
import com.cord.pos.enums.Status;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StaffRequestDTO {

    private String fullName;
    private String email;
    private String phoneNumber;
    private Role role;
    private Status status;
    private LocalDate joinDate;


}
