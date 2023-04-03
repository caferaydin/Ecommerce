package com.jpe.recommerce.business.abstracts;

import java.util.List;

import com.jpe.recommerce.business.DTO.requests.CreateCategoryRequest;
import com.jpe.recommerce.business.DTO.requests.UpdateCategoryRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllCategoryResponse;

public interface CategoryService {
    List<GetAllCategoryResponse> getAll();
    void add(CreateCategoryRequest createCategoryRequest);
    void update(UpdateCategoryRequest updateCategoryRequest);
    void delete(long categoryId);
}
