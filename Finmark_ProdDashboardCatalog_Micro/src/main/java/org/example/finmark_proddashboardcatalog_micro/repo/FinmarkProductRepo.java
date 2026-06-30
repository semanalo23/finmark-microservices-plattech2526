package org.example.finmark_proddashboardcatalog_micro.repo;

import org.example.finmark_proddashboardcatalog_micro.model.FinmarkProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinmarkProductRepo extends JpaRepository<FinmarkProduct, String> {

    List<FinmarkProduct> findByCategory(String category);
}
