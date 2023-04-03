package com.jpe.recommerce.business.abstracts;

import java.util.List;

import com.jpe.recommerce.business.DTO.requests.CreateProductRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllProductResponse;

public interface ProductService {
    List<GetAllProductResponse> getAll();
    void add(CreateProductRequest createProductRequest);
}
