package com.cord.pos.controller;

import com.cord.pos.dto.customer.CustomerRequestPojo;
import com.cord.pos.dto.customer.CustomerResponsePojo;
import com.cord.pos.dto.GlobalApiResponse;
import com.cord.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerController extends BaseController{

    private final CustomerService customerService;

    @PostMapping("/create-customer")
    public ResponseEntity<GlobalApiResponse> createCustomer(@RequestBody CustomerRequestPojo customerDTO){
        try{
            CustomerResponsePojo customerResponsePojo = customerService.create(customerDTO);
            return new ResponseEntity<>(successResponse("Customer created successfully", customerResponsePojo), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-customer")
    public ResponseEntity<GlobalApiResponse> listCustomers(){
        try {
             List<CustomerResponsePojo> customerResponsePojo = customerService.findAllCustomers();
             return new ResponseEntity<>(successResponse("Customer Listed Successfully", customerResponsePojo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(failureResponse(e.getMessage(),null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/delete-customer/{id}")
    public ResponseEntity<GlobalApiResponse> delete(@PathVariable long id){
        customerService.delete(id);
        return new ResponseEntity<>(successResponse("Customer Deleted Successfully", id),HttpStatus.OK);
    }

    @PutMapping("/update-customer/{id}")
    public ResponseEntity<GlobalApiResponse> update(@PathVariable long id, @RequestBody CustomerRequestPojo customerRequestPojo){
        CustomerResponsePojo customerResponsePojo = customerService.update(id, customerRequestPojo);
        return new ResponseEntity<>(successResponse("Customer Updated successfully", customerResponsePojo),HttpStatus.OK);
    }
}
