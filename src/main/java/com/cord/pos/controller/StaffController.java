package com.cord.pos.controller;

import com.cord.pos.dto.GlobalApiResponse;
import com.cord.pos.dto.staff.StaffRequestPojo;
import com.cord.pos.dto.staff.StaffResponsePojo;
import com.cord.pos.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("api/staff")
@RequiredArgsConstructor

public class StaffController extends BaseController{

    private final StaffService staffService;

    @PostMapping("/create-staff")
    public ResponseEntity<GlobalApiResponse> create(@RequestBody StaffRequestPojo staffRequestPojo){
        try{
            StaffResponsePojo staffResponsePojo = staffService.createStaff(staffRequestPojo);
            return new ResponseEntity<>(successResponse("Staff Created Successfully", staffResponsePojo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failureResponse(e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-staff")
    public ResponseEntity<GlobalApiResponse> list(){
        try{
            List<StaffResponsePojo> staffResponsePojo = staffService.getAllStaff();
            return new ResponseEntity<>(successResponse("Staff Listed Successfully", staffResponsePojo),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-staff/{id}")
    public ResponseEntity<GlobalApiResponse> delete(@PathVariable long id){
        staffService.deleteStaff(id);
        return new ResponseEntity<>(successResponse("Staff Deleted Successfuly", id),HttpStatus.OK);
    }

    @PutMapping("/update-staff/{id}")
    public ResponseEntity<GlobalApiResponse> update(@PathVariable long id, @RequestBody StaffRequestPojo staffRequestPojo){

        StaffResponsePojo staffResponsePojo = staffService.updateStaff(id, staffRequestPojo);
        return new ResponseEntity<>(successResponse("Staff Updated Successfully", staffResponsePojo),HttpStatus.OK);

    }

}
