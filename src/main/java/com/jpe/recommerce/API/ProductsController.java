package com.jpe.recommerce.API;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpe.recommerce.business.DTO.requests.CreateProductRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllProductResponse;
import com.jpe.recommerce.business.abstracts.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductsController {
    private ProductService productService;

    @GetMapping("/getAll")
    public List<GetAllProductResponse> getAll(){
        return productService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateProductRequest createProductRequest){
        this.productService.add(createProductRequest);
    }
}
