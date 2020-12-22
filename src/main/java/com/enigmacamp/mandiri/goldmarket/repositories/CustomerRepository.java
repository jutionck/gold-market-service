package com.enigmacamp.mandiri.goldmarket.repositories;

import com.enigmacamp.mandiri.goldmarket.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    Customer findByEmail(String email);
    Customer findByUserName(String userName);

}
