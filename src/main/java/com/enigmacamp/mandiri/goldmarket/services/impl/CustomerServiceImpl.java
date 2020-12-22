package com.enigmacamp.mandiri.goldmarket.services.impl;

import com.enigmacamp.mandiri.goldmarket.entities.Customer;
import com.enigmacamp.mandiri.goldmarket.entities.Role;
import com.enigmacamp.mandiri.goldmarket.repositories.CustomerRepository;
import com.enigmacamp.mandiri.goldmarket.repositories.RoleRepository;
import com.enigmacamp.mandiri.goldmarket.services.CustomerService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               RoleRepository roleRepository,
                               BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void create(Customer customer) {
        Date date = new Date();
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customer.setCreatedAt(date);
        Role userRole = roleRepository.findByRole("ADMIN");
        customer.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
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

    @Override
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Override
    public Customer findByUserName(String userName) {
        return customerRepository.findByUserName(userName);
    }
}
