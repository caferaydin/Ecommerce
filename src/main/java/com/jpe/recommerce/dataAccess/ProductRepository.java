package com.jpe.recommerce.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpe.recommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
