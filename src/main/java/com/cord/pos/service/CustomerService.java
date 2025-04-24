package com.cord.pos.service;

import com.cord.pos.dto.customer.CustomerRequestDTO;
import com.cord.pos.dto.customer.CustomerResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {

    CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO);

    List<CustomerResponseDTO> findAllCustomers();

    void delete(long id);

    CustomerResponseDTO update(long id, CustomerRequestDTO customerRequestDTO);

}
