package com.cord.pos.service;

import com.cord.pos.dto.staff.StaffRequestPojo;
import com.cord.pos.dto.staff.StaffResponsePojo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StaffService {

    StaffResponsePojo createStaff(StaffRequestPojo staffRequestPojo);

    List<StaffResponsePojo> getAllStaff();

    void deleteStaff(long id);

    StaffResponsePojo updateStaff(long id, StaffRequestPojo staffRequestPojo);

}
