package org.example.finmark_proddashboardcatalog_micro.service;

import org.example.finmark_proddashboardcatalog_micro.model.FinmarkProduct;
import org.example.finmark_proddashboardcatalog_micro.repo.FinmarkProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinmarkProductService {

    private final FinmarkProductRepo repo;

    public FinmarkProductService(FinmarkProductRepo repo) {
        this.repo = repo;
    }

    public List<FinmarkProduct> getProductsByCategory(String category) {
        return repo.findByCategory(category);
    }
}
