package com.jpe.recommerce.API;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpe.recommerce.business.DTO.requests.CreateCategoryRequest;
import com.jpe.recommerce.business.DTO.requests.UpdateCategoryRequest;
import com.jpe.recommerce.business.DTO.responses.GetAllCategoryResponse;
import com.jpe.recommerce.business.abstracts.CategoryService;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping()
    public List<GetAllCategoryResponse> getAll(){
        return this.categoryService.getAll();
    }
  
    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody CreateCategoryRequest createCategoryRequest){
       this.categoryService.add(createCategoryRequest);
    }
   
    @PutMapping("/update")
    public void update(@RequestBody UpdateCategoryRequest updateCategoryRequest){
        this.categoryService.update(updateCategoryRequest);
    }
    
    @DeleteMapping("/delete/{categoryId}")
    public void delete(@PathVariable long categoryId){
        this.categoryService.delete(categoryId);
    }
}
