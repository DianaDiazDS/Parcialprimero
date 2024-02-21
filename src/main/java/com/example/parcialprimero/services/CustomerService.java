package com.example.parcialprimero.services;


import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
//    @Autowired
//    private BillRepository billRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }


    public boolean updateCustomer(Long id,Customer customer){
        Customer findCustomer = findById(id);
        if (findCustomer != null){
            findCustomer.setName(customer.getName());

            customerRepository.save(findCustomer);
            return true;
        }else {
            return false;
        }
    }


}
