package com.jpe.recommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpe.recommerce.business.DTO.requests.CreateProductRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllProductResponse;
import com.jpe.recommerce.business.abstracts.ProductService;
import com.jpe.recommerce.core.utilities.mappers.ModelMapperService;
import com.jpe.recommerce.dataAccess.ProductRepository;
import com.jpe.recommerce.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements ProductService{
    private ProductRepository productRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllProductResponse> getAll() {
        List<Product> products = this.productRepository.findAll();
        // List<GetAllProductResponse> productResponse = new ArrayList<>();

        // for(Product product: products){
        //     GetAllProductResponse item = new GetAllProductResponse();
        //     item.setId(product.getId());
        //     item.setProductName(product.getProductName());
            
        //     productResponse.add(item);
        // }

        List<GetAllProductResponse> productResponse = products.stream()
            .map(product->this.modelMapperService.forResponse()
                .map(product, GetAllProductResponse.class)).collect(Collectors.toList());

        return productResponse;
    }

    @Override
    public void add(CreateProductRequest createProductRequest) {
       Product product = this.modelMapperService.forRequest().map(createProductRequest, Product.class);
       
       this.productRepository.save(product);
    }
    
}
