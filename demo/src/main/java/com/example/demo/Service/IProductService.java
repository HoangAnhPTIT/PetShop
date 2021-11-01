package com.example.demo.Service;

import com.example.demo.DTO.ProductDTO;

public interface IProductService {
    public boolean addProduct(ProductDTO productDTO);
    public ProductDTO getProduct(Long productId);

}
