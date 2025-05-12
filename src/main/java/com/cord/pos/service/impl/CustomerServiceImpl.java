package com.cord.pos.service.impl;

import com.cord.pos.dto.customer.CustomerRequestPojo;
import com.cord.pos.dto.customer.CustomerResponsePojo;
import com.cord.pos.entity.Customer;
import com.cord.pos.repository.CustomerRepo;
import com.cord.pos.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Override
    public CustomerResponsePojo create(CustomerRequestPojo customerRequestPojo) {

       Customer customer = Customer.builder()
               .fullName(customerRequestPojo.getFullName())
               .email(customerRequestPojo.getEmail())
               .phoneNumber(customerRequestPojo.getPhone())
               .initialDiscount(customerRequestPojo.getInitialDiscount())
               .customerType(customerRequestPojo.getCustomerType())
               .build();

       customerRepo.save(customer);

       CustomerResponsePojo customerResponsePojo = CustomerResponsePojo.builder()
               .id(customer.getId())
               .fullName(customerRequestPojo.getFullName())
               .email(customerRequestPojo.getEmail())
               .phone(customerRequestPojo.getPhone())
               .initialDiscount(customerRequestPojo.getInitialDiscount())
               .customerType(customerRequestPojo.getCustomerType())
               .build();

       return customerResponsePojo;

    }

    @Override
    public List<CustomerResponsePojo> findAllCustomers() {
        List<Customer> customer = customerRepo.findAll();
        List<CustomerResponsePojo> customerResponsePojo = new ArrayList<>();

        for(Customer c : customer){

            CustomerResponsePojo customerDTO = CustomerResponsePojo.builder()
                    .id(c.getId())
                    .fullName(c.getFullName())
                    .email(c.getEmail())
                    .phone(c.getPhoneNumber())
                    .initialDiscount(c.getInitialDiscount())
                    .customerType(c.getCustomerType())
                    .build();

            customerResponsePojo.add(customerDTO);
        }

        return customerResponsePojo;

    }

    @Override
    public void delete(long id) {

        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id : " + id));
        customerRepo.delete(customer);

    }

    @Override
    public CustomerResponsePojo update(long id, CustomerRequestPojo customerRequestPojo) {

        Customer exCustomer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id : "+id));
        exCustomer.setFullName(customerRequestPojo.getFullName());
        exCustomer.setEmail(customerRequestPojo.getEmail());
        exCustomer.setPhoneNumber(customerRequestPojo.getPhone());
        exCustomer.setInitialDiscount(customerRequestPojo.getInitialDiscount());
        exCustomer.setCustomerType(customerRequestPojo.getCustomerType());

        customerRepo.save(exCustomer);

        CustomerResponsePojo customerResponsePojo = CustomerResponsePojo.builder()
                .id(exCustomer.getId())
                .fullName(customerRequestPojo.getFullName())
                .email(customerRequestPojo.getEmail())
                .phone(customerRequestPojo.getPhone())
                .initialDiscount(customerRequestPojo.getInitialDiscount())
                .customerType(customerRequestPojo.getCustomerType())
                .build();

        return customerResponsePojo;

    }
}
