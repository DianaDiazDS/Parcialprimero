package com.example.parcialprimero.controllers;



import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.entities.Product;
import com.example.parcialprimero.response.ResponseHandler;
import com.example.parcialprimero.services.CustomerService;
import com.example.parcialprimero.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductControllers {

    @Autowired
    private ProductService productService;

    @GetMapping()
    public ResponseEntity<Object> findAll() {
        List<Product> products = productService.findAll();
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, products);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        try {
            Product product = productService.findById(id);
            if (product != null) {
                return ResponseHandler.generateResponse("Success", HttpStatus.OK, product);
            } else {
                return ResponseHandler.generateResponse("Product not found", HttpStatus.NOT_FOUND, null);
            }
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Product product) {
        try {
            Product savedProduct = productService.save(product);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, savedProduct);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        try {
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, productService.updateProduct(id, product));
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse("Error", HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }



}
