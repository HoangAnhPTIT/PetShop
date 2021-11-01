package com.example.demo.API;


import java.util.List;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ResponseDTO.BaseResponse;
import com.example.demo.Service.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryApi {
  
  @Autowired
  private ICategoryService categoryService;

  @PostMapping("/api/categories/create")
  @ResponseBody
  public BaseResponse addCategory(@RequestBody CategoryDTO categoryDTO){
    BaseResponse baseResponse = categoryService.addCategory(categoryDTO);
    return baseResponse;
  }
  
  @PostMapping("/api/categories/add-products/{id}")
  @ResponseBody
  public BaseResponse addProducts(@RequestBody CategoryDTO categoryDTO, @PathVariable Long id){
    categoryDTO.setId(id);
    BaseResponse baseResponse = categoryService.addProducts(categoryDTO);
    return baseResponse;
  } 

  @GetMapping("/api/categories/get-products/{id}")
  @ResponseBody
  public List<ProductDTO> getProducts(@PathVariable Long id){
    List<ProductDTO> productDTOs = categoryService.getProducts(id);
    return productDTOs;
  } 

}
