package com.example.demo.Repository;

import javax.transaction.Transactional;

import com.example.demo.Entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
  
}
