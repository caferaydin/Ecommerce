package com.jpe.recommerce.business.DTO.responses;

import java.util.List;

import com.jpe.recommerce.entities.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
    private long id;
    private String categoryName;
    private String subcategoryName;
    private String productName;
    private double price;
    private int stockAmount;
    private String stockAddress;
    private List<ProductImage> productImages;
}
