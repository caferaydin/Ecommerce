package com.jpe.recommerce.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jpe.recommerce.business.DTO.requests.CreateSubCategoryRequest;
import com.jpe.recommerce.business.DTO.requests.UpdateSubCategoryRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllSubCategoryResponse;
import com.jpe.recommerce.business.abstracts.SubCategoryService;

@RestController
@RequestMapping("/api/subcategory")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/getAll")
    public List<GetAllSubCategoryResponse> getAll(){
        return subCategoryService.getAll();
    }
    
    @GetMapping("/{categoryId}")
    public ResponseEntity<List<GetAllSubCategoryResponse>> getSubCategoriesByCategoryId(@PathVariable Long categoryId) {
        List<GetAllSubCategoryResponse> subCategories = subCategoryService.getSubCategoriesByCategoryId(categoryId);
        return ResponseEntity.ok(subCategories);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateSubCategoryRequest createSubCategoryRequest){
        this.subCategoryService.add(createSubCategoryRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateSubCategoryRequest updateSubCategoryRequest){
        this.subCategoryService.update(updateSubCategoryRequest);
    }
    
    @DeleteMapping("/delete/{subcategoryId}")
    public void delete(@PathVariable long subcategoryId){
        this.subCategoryService.delete(subcategoryId);
    }
    
}
