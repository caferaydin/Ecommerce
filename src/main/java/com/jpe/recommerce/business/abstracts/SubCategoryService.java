package com.jpe.recommerce.business.abstracts;

import java.util.List;

import com.jpe.recommerce.business.DTO.requests.CreateSubCategoryRequest;
import com.jpe.recommerce.business.DTO.requests.UpdateSubCategoryRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllSubCategoryResponse;

public interface SubCategoryService {
    List<GetAllSubCategoryResponse> getAll();
    List<GetAllSubCategoryResponse> getSubCategoriesByCategoryId(Long categoryId);
    void add(CreateSubCategoryRequest createSubCategoryRequest);
    void update(UpdateSubCategoryRequest updateSubCategoryRequest);
    void delete(long subcategoryId);

}
