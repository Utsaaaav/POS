package com.cord.pos.service;

import com.cord.pos.dto.customer.CustomerRequestPojo;
import com.cord.pos.dto.customer.CustomerResponsePojo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CustomerService {

    CustomerResponsePojo create(CustomerRequestPojo customerRequestPojo);

    List<CustomerResponsePojo> findAllCustomers();

    void delete(long id);

    CustomerResponsePojo update(long id, CustomerRequestPojo customerRequestPojo);

}
