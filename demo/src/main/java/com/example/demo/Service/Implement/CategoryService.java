package com.example.demo.Service.Implement;

import java.lang.reflect.Type;
import java.util.List;

import com.example.demo.DTO.CategoryDTO;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.DTO.ResponseDTO.BaseResponse;
import com.example.demo.Entity.CategoryEntity;
import com.example.demo.Entity.ProductEntity;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.ICategoryService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class CategoryService implements ICategoryService{

  @Autowired
  private ModelMapper mapper;
 
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductRepository productRepository;

  @Override
  public BaseResponse addCategory(CategoryDTO categoryDTO) {
    CategoryEntity categoryEntity = mapper.map(categoryDTO, CategoryEntity.class);
    try {
      categoryRepository.save(categoryEntity);
      return new BaseResponse("Success", true);
    } catch (Exception e) {
      return new BaseResponse(e.getMessage(), false);
    }
  }

  @Override
  public BaseResponse addProducts(CategoryDTO categoryDTO) {
    try {
      List<ProductEntity> productEntities = productRepository.findAllById(categoryDTO.getProductIds());
      CategoryEntity categoryEntity = categoryRepository.findById(categoryDTO.getId()).get();
      categoryEntity.setProductEntities(productEntities);
      categoryRepository.save(categoryEntity);
      return new BaseResponse("Success", true);
    } catch (Exception e) {
      return new BaseResponse(e.getMessage(), false);
    }
  }

  @Override
  public List<ProductDTO> getProducts(Long categoryId) {
    try {
      CategoryEntity categoryEntity = categoryRepository.findById(categoryId).get();
      List<ProductEntity> productEntities = categoryEntity.getProductEntities();
      Type listType = new TypeToken<List<ProductDTO>>() {
      }.getType();
      List<ProductDTO> productDTOs = mapper.map(productEntities, listType);
      return productDTOs;
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return null;
    }
  }
  
}
