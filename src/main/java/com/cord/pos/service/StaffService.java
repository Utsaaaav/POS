package com.cord.pos.service;

import com.cord.pos.dto.staff.StaffRequestDTO;
import com.cord.pos.dto.staff.StaffResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StaffService {

    StaffResponseDTO createStaff(StaffRequestDTO staffRequestDTO);

    List<StaffResponseDTO> getAllStaff();

    void deleteStaff(long id);

    StaffResponseDTO updateStaff(long id, StaffRequestDTO staffRequestDTO);

}
