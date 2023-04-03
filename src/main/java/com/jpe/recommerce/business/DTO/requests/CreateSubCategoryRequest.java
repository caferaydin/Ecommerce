package com.jpe.recommerce.business.DTO.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubCategoryRequest {
    private String subcategoryName;
    private boolean status;
    private long categoryId;
}
