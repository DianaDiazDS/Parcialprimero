package com.example.parcialprimero.repositories;


import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Query(value = "SELECT SUM(total) FROM bills WHERE FK_idguarderia = :customerId", nativeQuery = true)
//    Double getTotalBillAmountForCustomer(@Param("customerId") Integer customerId);


}
