package com.example.demo.DTO;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class CategoryDTO {
  private Long id;

  private String name;

  private String desc;

  List<Long> productIds;
}
