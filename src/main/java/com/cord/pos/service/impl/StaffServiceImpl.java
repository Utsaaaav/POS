package com.cord.pos.service.impl;

import com.cord.pos.dto.staff.StaffRequestDTO;
import com.cord.pos.dto.staff.StaffResponseDTO;
import com.cord.pos.entity.Staff;
import com.cord.pos.enums.Status;
import com.cord.pos.repository.StaffRepo;
import com.cord.pos.service.StaffService;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StaffServiceImpl implements StaffService {

    private final StaffRepo staffRepo;

    @Override
    public StaffResponseDTO createStaff(StaffRequestDTO staffRequestDTO) {

        Staff staff = Staff.builder()
                .fullName(staffRequestDTO.getFullName())
                .email(staffRequestDTO.getEmail())
                .phoneNumber(staffRequestDTO.getPhoneNumber())
                .role(staffRequestDTO.getRole())
                .status(staffRequestDTO.getStatus())
                .joinDate(staffRequestDTO.getJoinDate())
                .build();

        staffRepo.save(staff);

        StaffResponseDTO staffResponseDTO = StaffResponseDTO.builder()
                .id(staff.getId())
                .fullName(staffRequestDTO.getFullName())
                .email(staffRequestDTO.getEmail())
                .phoneNumber(staffRequestDTO.getPhoneNumber())
                .role(staffRequestDTO.getRole())
                .status(staff.getStatus())
                .joinDate(staffRequestDTO.getJoinDate())
                .build();

        return staffResponseDTO;
    }

    @Override
    public List<StaffResponseDTO> getAllStaff() {

        List<Staff> staff = staffRepo.findAll();
        List<StaffResponseDTO> staffResponseDto = new ArrayList<>();
        for (Staff s : staff){
            StaffResponseDTO staffResponseDTO = StaffResponseDTO.builder()
                    .id(s.getId())
                    .fullName(s.getFullName())
                    .email(s.getEmail())
                    .phoneNumber(s.getPhoneNumber())
                    .role(s.getRole())
                    .status(s.getStatus())
                    .joinDate(s.getJoinDate())
                    .build();

            staffResponseDto.add(staffResponseDTO);
        }
        return staffResponseDto;
    }

    @Override
    public void deleteStaff(long id) {

        Staff staff = staffRepo.findById(id).orElseThrow(()-> new RuntimeException("Staff not found with id "+ id));
        staffRepo.delete(staff);

    }

    @Override
    public StaffResponseDTO updateStaff(long id, StaffRequestDTO staffRequestDTO) {

        Staff exStaff = staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found with id "+id));
        exStaff.setFullName(staffRequestDTO.getFullName());
        exStaff.setEmail(staffRequestDTO.getEmail());
        exStaff.setPhoneNumber(staffRequestDTO.getPhoneNumber());
        exStaff.setRole(staffRequestDTO.getRole());
        exStaff.setStatus(staffRequestDTO.getStatus());
        exStaff.setJoinDate(staffRequestDTO.getJoinDate());

        staffRepo.save(exStaff);

        StaffResponseDTO responseDTO = StaffResponseDTO.builder()
                .id(exStaff.getId())
                .fullName(staffRequestDTO.getFullName())
                .email(staffRequestDTO.getEmail())
                .phoneNumber(staffRequestDTO.getPhoneNumber())
                .role(staffRequestDTO.getRole())
                .status(staffRequestDTO.getStatus())
                .joinDate(staffRequestDTO.getJoinDate())
                .build();

        return responseDTO;


    }
}
