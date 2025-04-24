package com.cord.pos.service.impl;

import com.cord.pos.dto.customer.CustomerRequestDTO;
import com.cord.pos.dto.customer.CustomerResponseDTO;
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
    public CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO) {

       Customer customer = Customer.builder()
               .fullName(customerRequestDTO.getFullName())
               .email(customerRequestDTO.getEmail())
               .phoneNumber(customerRequestDTO.getPhone())
               .initialDiscount(customerRequestDTO.getInitialDiscount())
               .customerType(customerRequestDTO.getCustomerType())
               .build();

       customerRepo.save(customer);

       CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.builder()
               .id(customer.getId())
               .fullName(customerRequestDTO.getFullName())
               .email(customerRequestDTO.getEmail())
               .phone(customerRequestDTO.getPhone())
               .initialDiscount(customerRequestDTO.getInitialDiscount())
               .customerType(customerRequestDTO.getCustomerType())
               .build();

       return customerResponseDTO;

    }

    @Override
    public List<CustomerResponseDTO> findAllCustomers() {
        List<Customer> customer = customerRepo.findAll();
        List<CustomerResponseDTO> customerResponseDTO = new ArrayList<>();

        for(Customer c : customer){

            CustomerResponseDTO customerDTO = CustomerResponseDTO.builder()
                    .id(c.getId())
                    .fullName(c.getFullName())
                    .email(c.getEmail())
                    .phone(c.getPhoneNumber())
                    .initialDiscount(c.getInitialDiscount())
                    .customerType(c.getCustomerType())
                    .build();

            customerResponseDTO.add(customerDTO);
        }

        return customerResponseDTO;

    }

    @Override
    public void delete(long id) {

        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id : " + id));
        customerRepo.delete(customer);

    }

    @Override
    public CustomerResponseDTO update(long id, CustomerRequestDTO customerRequestDTO) {

        Customer exCustomer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id : "+id));
        exCustomer.setFullName(customerRequestDTO.getFullName());
        exCustomer.setEmail(customerRequestDTO.getEmail());
        exCustomer.setPhoneNumber(customerRequestDTO.getPhone());
        exCustomer.setInitialDiscount(customerRequestDTO.getInitialDiscount());
        exCustomer.setCustomerType(customerRequestDTO.getCustomerType());

        customerRepo.save(exCustomer);

        CustomerResponseDTO customerResponseDTO = CustomerResponseDTO.builder()
                .id(exCustomer.getId())
                .fullName(customerRequestDTO.getFullName())
                .email(customerRequestDTO.getEmail())
                .phone(customerRequestDTO.getPhone())
                .initialDiscount(customerRequestDTO.getInitialDiscount())
                .customerType(customerRequestDTO.getCustomerType())
                .build();

        return customerResponseDTO;

    }
}
