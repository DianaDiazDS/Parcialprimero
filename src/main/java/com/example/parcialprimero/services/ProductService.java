package com.example.parcialprimero.services;


import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.entities.Product;
import com.example.parcialprimero.entities.Sale;
import com.example.parcialprimero.repositories.CustomerRepository;
import com.example.parcialprimero.repositories.ProductRepository;
import com.example.parcialprimero.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean updateProduct(Long id, Product product) {
        Product foundProduct = findById(id);
        if (foundProduct != null) {
            foundProduct.setName(product.getName());
            foundProduct.setCantidad(product.getCantidad());

            productRepository.save(foundProduct);

            return true;
        } else {
            return false;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
