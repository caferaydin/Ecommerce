package com.jpe.recommerce.business.DTO.requests;

import java.util.List;

import com.jpe.recommerce.entities.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {

    private String categoryName;
    private String subcategoryName;
    private String productName;
    private double price;
    private int stockAmount;
    private String stockAddress;
    private List<ProductImage> productImages;
    private boolean status;
}
