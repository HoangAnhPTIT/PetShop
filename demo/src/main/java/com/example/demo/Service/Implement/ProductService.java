package com.example.demo.Service.Implement;

import java.lang.reflect.Type;
import java.util.List;

import com.example.demo.DTO.ImageDTO;
import com.example.demo.DTO.ProductDTO;
import com.example.demo.Entity.ImageEntity;
import com.example.demo.Entity.ProductEntity;
import com.example.demo.Repository.ImageRepository;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.IProductService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
  @Autowired
  private ModelMapper mapper;

  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ImageRepository imageRepository;

  @Override
  public boolean addProduct(ProductDTO productDTO) {
    try {
      ProductEntity productEntity = mapper.map(productDTO, ProductEntity.class);
      ProductEntity productEntitySave = productRepository.save(productEntity);
      List<ImageDTO> imageDTOs = productDTO.getImageDTOs();
      Type listType = new TypeToken<List<ImageEntity>>() {
      }.getType();
      List<ImageEntity> imageEntities = mapper.map(imageDTOs, listType);
      for (ImageEntity entity : imageEntities) {
        entity.setProductEntity(productEntitySave);
      }
      imageRepository.saveAll(imageEntities);
      return true;
    } catch (Exception e) {
      throw e;
    }

  }

  @Override
  public ProductDTO getProduct(Long productId) {
    try {
      ProductEntity productEntity = productRepository.findById(productId).get();
      List<ImageEntity> imageEntities = productEntity.getImageEntities();
      Type listType = new TypeToken<List<ImageDTO>>() {
      }.getType();
      ProductDTO productDTO = mapper.map(productEntity, ProductDTO.class);
      List<ImageDTO> imageDTOs = mapper.map(imageEntities, listType);
      productDTO.setImageDTOs(imageDTOs);
      return productDTO;
    } catch (Exception e) {
      throw e;
    }
  }

}
