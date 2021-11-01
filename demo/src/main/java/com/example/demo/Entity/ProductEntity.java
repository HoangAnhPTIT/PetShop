package com.example.demo.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter @Setter @RequiredArgsConstructor
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "specific_attribute")
	private String specificAttribute;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "productEntities")
	private List<CategoryEntity> categoryEntities;
	
	@JsonBackReference("productEntity")
	@OneToMany(mappedBy = "productEntity")
	private List<ImageEntity> imageEntities;
}
