package com.guilhermao.dsvendas.services;

import java.util.List;

import com.guilhermao.dsvendas.DTO.SaleDTO;
import com.guilhermao.dsvendas.DTO.SaleSuccessDTO;
import com.guilhermao.dsvendas.DTO.SaleSumDTO;
import com.guilhermao.dsvendas.entities.Sale;
import com.guilhermao.dsvendas.repositories.SaleRepository;
import com.guilhermao.dsvendas.repositories.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }

    @Transactional(readOnly = true)
    public List<SaleSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SaleSuccessDTO> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
