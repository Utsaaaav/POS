package com.cord.pos.controller;

import com.cord.pos.dto.customer.CustomerRequestDTO;
import com.cord.pos.dto.customer.CustomerResponseDTO;
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
    public ResponseEntity<GlobalApiResponse> createCustomer(@RequestBody CustomerRequestDTO customerDTO){
        try{
            CustomerResponseDTO customerResponseDTO = customerService.create(customerDTO);
            return new ResponseEntity<>(successResponse("Customer created successfully", customerResponseDTO), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(failureResponse(e.getMessage(), null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/list-customer")
    public ResponseEntity<GlobalApiResponse> listCustomers(){
        try {
             List<CustomerResponseDTO> customerResponseDTO = customerService.findAllCustomers();
             return new ResponseEntity<>(successResponse("Customer Listed Successfully", customerResponseDTO), HttpStatus.OK);
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
    public ResponseEntity<GlobalApiResponse> update(@PathVariable long id, @RequestBody CustomerRequestDTO customerRequestDTO){
        CustomerResponseDTO customerResponseDTO = customerService.update(id, customerRequestDTO);
        return new ResponseEntity<>(successResponse("Customer Updated successfully", customerResponseDTO),HttpStatus.OK);
    }
}
