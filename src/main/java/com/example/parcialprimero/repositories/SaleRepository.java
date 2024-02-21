package com.example.parcialprimero.repositories;


import com.example.parcialprimero.entities.Customer;
import com.example.parcialprimero.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

//    @Query(value = "SELECT SUM(total) FROM bills WHERE FK_idguarderia = :customerId", nativeQuery = true)
//    Double getTotalBillAmountForCustomer(@Param("customerId") Integer customerId);


}
