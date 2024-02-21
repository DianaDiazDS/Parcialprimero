package com.example.parcialprimero.controllers;


import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.entities.Product;
import com.example.parcialprimero.entities.Sale;
import com.example.parcialprimero.response.ResponseHandler;
import com.example.parcialprimero.services.CustomerService;
import com.example.parcialprimero.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleControllers {

    @Autowired
    private SaleService saleService;

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Sale> sales = saleService.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, sales);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            Sale sale = saleService.findById(id);
            if (sale != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, sale);
            } else {
                return ResponseHandler.generateResponse("Sale not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> save(@PathVariable("id") Long id,@RequestBody Sale sale){
        try {
            Customer cliente = customerService.findById(id);
            if (cliente != null){
                Sale result = saleService.save(sale,cliente);
                return ResponseHandler.generateResponse("Success Author",HttpStatus.CREATED,sale);
            }
            return ResponseHandler.generateResponse("Success Author",HttpStatus.NOT_FOUND,null);
        }catch (Exception e){
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null );
        }
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> updateSale(@PathVariable Long id, @RequestBody Sale sale) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, saleService.updateSale(id, sale));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteSale(@PathVariable Long id) {
        try {
            saleService.deleteSale(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }



}
