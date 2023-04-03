package com.jpe.recommerce.business.concretes;

// import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpe.recommerce.business.DTO.requests.CreateCategoryRequest;
import com.jpe.recommerce.business.DTO.requests.UpdateCategoryRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllCategoryResponse;
import com.jpe.recommerce.business.abstracts.CategoryService;
import com.jpe.recommerce.core.utilities.mappers.ModelMapperService;
import com.jpe.recommerce.dataAccess.CategoryRepository;
import com.jpe.recommerce.entities.Category;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private CategoryRepository categoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllCategoryResponse> getAll() {
        List<Category> categories = this.categoryRepository.findAll();
        // List<GetAllCategoryResponse> categoryResponse = new ArrayList<>();

        // for(Category category: categories){
        //     GetAllCategoryResponse categoryItem = new GetAllCategoryResponse();
        //     categoryItem.setId(category.getId());
        //     categoryItem.setCategoryName(category.getCategoryName());
        //     categoryItem.setStatus(category.isStatus());
        //     categoryResponse.add(categoryItem);
        // }
        List<GetAllCategoryResponse> categoryResponse = categories.stream()
            .map(category->this.modelMapperService.forResponse()
                .map(category, GetAllCategoryResponse.class)).collect(Collectors.toList());
            
            return categoryResponse;
        // return categoryResponse;

    }

    @Override
    public void add(CreateCategoryRequest createCategoryRequest) {
        // Category category = new Category();

        // category.setCategoryName(createCategoryRequest.getCategoryName());
        // category.setStatus(createCategoryRequest.isStatus());
        Category category = this.modelMapperService.forRequest().map(createCategoryRequest, Category.class);

       this.categoryRepository.save(category);
    }

    @Override
    public void update(UpdateCategoryRequest updateCategoryRequest) {
        
        Category category = this.modelMapperService.forRequest().map(updateCategoryRequest, Category.class);
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(long categoryId) {
        this.categoryRepository.deleteById(categoryId);
    }

   

  




    
}
