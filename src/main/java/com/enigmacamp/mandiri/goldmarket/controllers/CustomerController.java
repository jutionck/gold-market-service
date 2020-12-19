package com.enigmacamp.mandiri.goldmarket.controllers;

import com.enigmacamp.mandiri.goldmarket.entities.Customer;
import com.enigmacamp.mandiri.goldmarket.services.CustomerService;
import com.enigmacamp.mandiri.goldmarket.utils.ResponseUtil;
import com.enigmacamp.mandiri.goldmarket.utils.WebPageResponse;
import com.enigmacamp.mandiri.goldmarket.utils.WebResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final ResponseUtil<Customer> responseUtil;

    public CustomerController(CustomerService customerService,
                              ResponseUtil<Customer> responseUtil) {
        this.customerService = customerService;
        this.responseUtil = responseUtil;
    }

    @PostMapping(
            value = "",
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<WebResponse<Customer>> create(@RequestBody Customer customer) {
        customerService.create(customer);
        return responseUtil.build(customer, HttpStatus.CREATED, "CUSTOMER CREATED!");
    }

    @GetMapping(
            value = "/{id}",
            produces = "application/json"
    )
    public ResponseEntity<WebResponse<Customer>> getById(@PathVariable String id) {
        Customer customer = customerService.get(id);
        return responseUtil.build(customer);
    }

    @PutMapping(
            value = "/{id}",
            produces = "application/json",
            consumes = "application/json"
    )
    public ResponseEntity<WebResponse<Customer>> update(
            @PathVariable String id,
            @RequestBody Customer customer) {
        customer.setId(id);
        customerService.update(customer);
        return responseUtil.build(customer, HttpStatus.CREATED, "CUSTOMER UPDATED!");
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public ResponseEntity<WebResponse<Customer>> delete(@PathVariable String id) {
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(
            value = "",
            produces = "application/json"
    )
    public ResponseEntity<WebPageResponse<Customer>> list(
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "rows", defaultValue = "10") Integer rows) {

        PageRequest pageRequest = PageRequest.of(page, rows, Sort.by(Sort.Direction.ASC, "firstName"));
        Page<Customer> customers = customerService.list(pageRequest);
        return responseUtil.build(customers);
    }
}
