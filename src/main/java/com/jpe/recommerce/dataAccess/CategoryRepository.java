package com.jpe.recommerce.dataAccess;


import org.springframework.data.jpa.repository.JpaRepository;

import com.jpe.recommerce.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    
}
