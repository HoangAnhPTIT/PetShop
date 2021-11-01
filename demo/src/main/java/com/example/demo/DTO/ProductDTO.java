package com.example.demo.DTO;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter @RequiredArgsConstructor
public class ProductDTO {
	private Long id;
	
	private String name;
	
	private float price;
	
	private String description;
	
	private String specificAttribute;

  private List<ImageDTO> imageDTOs;
}
