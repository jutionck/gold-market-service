package com.enigmacamp.mandiri.goldmarket.services;

import com.enigmacamp.mandiri.goldmarket.entities.Customer;

public interface CustomerService extends Services<Customer> {
    Customer findByEmail(String email);
    Customer findByUserName(String userName);
}