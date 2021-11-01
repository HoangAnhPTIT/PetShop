package com.example.demo.Repository;

import javax.transaction.Transactional;

import com.example.demo.Entity.ImageEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<ImageEntity, Long> {
    
}
