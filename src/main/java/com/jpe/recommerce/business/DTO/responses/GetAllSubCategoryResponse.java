package com.jpe.recommerce.business.DTO.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSubCategoryResponse {
    private long id;
    private String subcategoryName;
    private boolean status;
    private long categoryId;
}
