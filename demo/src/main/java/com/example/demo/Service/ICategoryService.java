package com.example.demo.Service;

import java.util.List;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ResponseDTO.BaseResponse;

public interface ICategoryService {
  public BaseResponse addCategory(CategoryDTO categoryDTO);

  public BaseResponse addProducts(CategoryDTO categoryDTO);

  public List<ProductDTO> getProducts(Long categoryId);
}
