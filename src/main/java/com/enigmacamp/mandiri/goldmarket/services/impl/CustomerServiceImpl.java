package com.enigmacamp.mandiri.goldmarket.services.impl;

import com.enigmacamp.mandiri.goldmarket.entities.Customer;
import com.enigmacamp.mandiri.goldmarket.repositories.CustomerRepository;
import com.enigmacamp.mandiri.goldmarket.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(Customer customer) {
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        customerRepository.save(customer);
    }

    @Override
    public Customer get(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Customer> list(Pageable pager) {
        return customerRepository.findAll(pager);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }


}
