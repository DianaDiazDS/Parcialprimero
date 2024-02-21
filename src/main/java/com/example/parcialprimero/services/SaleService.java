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
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;


    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }



//    public Sale save(Sale sale, Customer customer) {
//        if (cantidades(sale.getProducts())) {
//            sale.setCustomer(customer);
//            return saleRepository.save(sale);
//        }
//        else {
//            return null;
//        }
//    }


    public Sale save(Sale sale, Customer customer) {
        if (cantidades(sale.getProducts())) {
            // Restar la cantidad de productos disponibles
            for (Product product : sale.getProducts()) {
                Product storedProduct = productService.findById(product.getIdProduct());
                if (storedProduct != null) {
                    Long remainingQuantity = storedProduct.getCantidad() - product.getCantidad();
                    storedProduct.setCantidad(remainingQuantity);
                    productService.save(storedProduct); // Actualizar la cantidad en la base de datos
                }
            }
            sale.setCustomer(customer);
            return saleRepository.save(sale);
        } else {
            return null;
        }
    }

    public boolean cantidades(List<Product> products){
        for (Product product : products) {
            Product storedProduct = productService.findById(product.getIdProduct());
            if (storedProduct != null && product.getCantidad() > storedProduct.getCantidad()) {
                return false;
            }
        }
        return true;
    }


    public boolean updateSale(Long id, Sale sale) {
        Sale foundSale = findById(id);
        if (foundSale != null) {
            foundSale.setDate(sale.getDate());
            foundSale.setTotal(sale.getTotal());
            foundSale.setName(sale.getName());
            foundSale.setCustomer(sale.getCustomer());
            foundSale.setProducts(sale.getProducts());

            saleRepository.save(foundSale);
            return true;
        } else {
            return false;
        }
    }
    public Product updateProduct(Long id, Product product, Long cont) {
        Product productFound = productService.findById(id);
        productFound.setName(product.getName());
        productFound.setCantidad(product.getCantidad());
        productRepository.save(productFound);
        return productFound;
    }



    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

}
