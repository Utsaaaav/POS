package com.cord.pos.service.impl;

import com.cord.pos.dto.staff.StaffRequestPojo;
import com.cord.pos.dto.staff.StaffResponsePojo;
import com.cord.pos.entity.Staff;
import com.cord.pos.repository.StaffRepo;
import com.cord.pos.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class StaffServiceImpl implements StaffService {

    private final StaffRepo staffRepo;

    @Override
    public StaffResponsePojo createStaff(StaffRequestPojo staffRequestPojo) {

        Staff staff = Staff.builder()
                .fullName(staffRequestPojo.getFullName())
                .email(staffRequestPojo.getEmail())
                .phoneNumber(staffRequestPojo.getPhoneNumber())
                .role(staffRequestPojo.getRole())
                .status(staffRequestPojo.getStatus())
                .joinDate(staffRequestPojo.getJoinDate())
                .build();

        staffRepo.save(staff);

        StaffResponsePojo staffResponsePojo = StaffResponsePojo.builder()
                .id(staff.getId())
                .fullName(staffRequestPojo.getFullName())
                .email(staffRequestPojo.getEmail())
                .phoneNumber(staffRequestPojo.getPhoneNumber())
                .role(staffRequestPojo.getRole())
                .status(staff.getStatus())
                .joinDate(staffRequestPojo.getJoinDate())
                .build();

        return staffResponsePojo;
    }

    @Override
    public List<StaffResponsePojo> getAllStaff() {

        List<Staff> staff = staffRepo.findAll();
        List<StaffResponsePojo> staffResponsePojo = new ArrayList<>();
        for (Staff s : staff){
            StaffResponsePojo staffResponsePojo = StaffResponsePojo.builder()
                    .id(s.getId())
                    .fullName(s.getFullName())
                    .email(s.getEmail())
                    .phoneNumber(s.getPhoneNumber())
                    .role(s.getRole())
                    .status(s.getStatus())
                    .joinDate(s.getJoinDate())
                    .build();

            staffResponsePojo.add(staffResponsePojo);
        }
        return staffResponsePojo;
    }

    @Override
    public void deleteStaff(long id) {

        Staff staff = staffRepo.findById(id).orElseThrow(()-> new RuntimeException("Staff not found with id "+ id));
        staffRepo.delete(staff);

    }

    @Override
    public StaffResponsePojo updateStaff(long id, StaffRequestPojo staffRequestPojo) {

        Staff exStaff = staffRepo.findById(id).orElseThrow(() -> new RuntimeException("Staff not found with id "+id));
        exStaff.setFullName(staffRequestPojo.getFullName());
        exStaff.setEmail(staffRequestPojo.getEmail());
        exStaff.setPhoneNumber(staffRequestPojo.getPhoneNumber());
        exStaff.setRole(staffRequestPojo.getRole());
        exStaff.setStatus(staffRequestPojo.getStatus());
        exStaff.setJoinDate(staffRequestPojo.getJoinDate());

        staffRepo.save(exStaff);

        StaffResponsePojo responseDTO = StaffResponsePojo.builder()
                .id(exStaff.getId())
                .fullName(staffRequestPojo.getFullName())
                .email(staffRequestPojo.getEmail())
                .phoneNumber(staffRequestPojo.getPhoneNumber())
                .role(staffRequestPojo.getRole())
                .status(staffRequestPojo.getStatus())
                .joinDate(staffRequestPojo.getJoinDate())
                .build();

        return responseDTO;


    }
}
