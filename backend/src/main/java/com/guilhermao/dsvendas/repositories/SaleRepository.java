package com.guilhermao.dsvendas.repositories;

import com.guilhermao.dsvendas.entities.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    
}
