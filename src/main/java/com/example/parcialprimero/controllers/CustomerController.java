package com.example.parcialprimero.controllers;


import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.response.ResponseHandler;
import com.example.parcialprimero.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService2;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Customer> list = customerService2.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, list);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {

            Customer customer = customerService2.findById(id);
            if (customerService2.findById(id)  != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK,customerService2.findById(id) );
            } else {
                return ResponseHandler.generateResponse("customer not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }



    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = customerService2.save(customer);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, savedCustomer);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable  Long id, @RequestBody Customer customer){
        try {
            return ResponseHandler.generateResponse("Succes",HttpStatus.OK,customerService2.updateCustomer(id,customer));
        }catch (Exception e){
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR,e);
        }
    }








}
