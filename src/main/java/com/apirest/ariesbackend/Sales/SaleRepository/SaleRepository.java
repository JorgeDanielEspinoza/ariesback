package com.apirest.ariesbackend.Sales.SaleRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.ariesbackend.Sales.Sale.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Integer> {
    List<Sale> findByIdUser(Integer idUser);
}
