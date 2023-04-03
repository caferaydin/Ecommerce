package com.jpe.recommerce.business.DTO.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubCategoryRequest {
    private long id;
    private long categoryId;
    private String subcategoryName;
    private boolean status;
}
