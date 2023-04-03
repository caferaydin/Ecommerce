package com.jpe.recommerce.dataAccess;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpe.recommerce.entities.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<SubCategory> findByCategory_Id(Long categoryId);
}
