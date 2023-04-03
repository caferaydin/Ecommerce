package com.jpe.recommerce.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jpe.recommerce.business.DTO.requests.CreateSubCategoryRequest;
import com.jpe.recommerce.business.DTO.requests.UpdateSubCategoryRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllSubCategoryResponse;
import com.jpe.recommerce.business.abstracts.SubCategoryService;
import com.jpe.recommerce.core.utilities.mappers.ModelMapperService;
import com.jpe.recommerce.dataAccess.SubCategoryRepository;
import com.jpe.recommerce.entities.SubCategory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SubCategoryManager implements SubCategoryService {
    private SubCategoryRepository subCategoryRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllSubCategoryResponse> getAll(){
        List<SubCategory> subCategories = this.subCategoryRepository.findAll();
        // List<GetAllSubCategoryResponse> subcategoryResponse = new ArrayList<>();

        // for(SubCategory subCategory: subCategories){
        //     GetAllSubCategoryResponse item = new GetAllSubCategoryResponse();
        //     item.setId(subCategory.getId());
        //     item.setSubcategoryName(subCategory.getSubcategoryName());
            
        //     item.setStatus(subCategory.isStatus());

        //     subcategoryResponse.add(item);
        // }
        List<GetAllSubCategoryResponse> subcategoryResponse = subCategories.stream()
            .map(subCategory->this.modelMapperService.forResponse()
                .map(subCategory, GetAllSubCategoryResponse.class)).collect(Collectors.toList());
        
        return subcategoryResponse;
    }


    @Override
    public List<GetAllSubCategoryResponse> getSubCategoriesByCategoryId(Long categoryId) {
        
        List<SubCategory> subCategories = subCategoryRepository.findByCategory_Id(categoryId);
        // List<GetAllSubCategoryResponse> subCategoryResponse = new ArrayList<>();
        
        // for (SubCategory subCategory : subCategories) {
        //     GetAllSubCategoryResponse response = new GetAllSubCategoryResponse();
        //     response.setId(subCategory.getId());
        //     response.setSubcategoryName(subCategory.getSubcategoryName());
        //     response.setStatus(subCategory.isStatus());
            
        //     subCategoryResponse.add(response);
        // }
        List<GetAllSubCategoryResponse> subCategoryResponse = subCategories.stream()
            .map(subCategory->this.modelMapperService.forResponse()
                .map(subCategory, GetAllSubCategoryResponse.class)).collect(Collectors.toList());
        
        return subCategoryResponse;
    }



    @Override
    public void add(CreateSubCategoryRequest createSubCategoryRequest) {
        // SubCategory subCategory = new SubCategory();

        // subCategory.setSubcategoryName(createSubCategoryRequest.getSubcategoryName());
        // subCategory.setStatus(createSubCategoryRequest.isStatus());
        // subCategory.setCategory(createSubCategoryRequest.getCategory());

        // this.subCategoryRepository.save(subCategory);

        SubCategory subCategory = this.modelMapperService.forRequest().map(createSubCategoryRequest, SubCategory.class);
        this.subCategoryRepository.save(subCategory);

    }

   
    @Override
    public void update(UpdateSubCategoryRequest updateSubCategoryRequest) {
        SubCategory subCategory = this.modelMapperService.forRequest().map(updateSubCategoryRequest, SubCategory.class);
        this.subCategoryRepository.save(subCategory);
    }


    @Override
    public void delete(long subcategoryId) {
        this.subCategoryRepository.deleteById(subcategoryId);
    }


   
   

}
