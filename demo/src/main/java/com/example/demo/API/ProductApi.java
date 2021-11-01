package com.example.demo.API;

import com.example.demo.DTO.ProductDTO;
import com.example.demo.Service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductApi {
    @Autowired
    private IProductService productService;

    @PostMapping(path = "/api/products/create")
    @ResponseBody
    public Boolean addProduct(@RequestBody ProductDTO productDTO){
        try {
            boolean status = productService.addProduct(productDTO);
            return status;
        } catch (Exception e) {
            return false;
        }
    }
    
    @GetMapping(path = "/api/products/find/{id}")
    @ResponseBody
    public ProductDTO getProduct(@PathVariable Long id){
        try {
            ProductDTO productDTO = productService.getProduct(id);
            return productDTO;
        } catch (Exception e) {
            return new ProductDTO();

        }
    }
}
