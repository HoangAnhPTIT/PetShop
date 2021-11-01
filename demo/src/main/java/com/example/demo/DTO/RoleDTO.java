package com.example.demo.DTO;

import com.example.demo.Entity.EnumType.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class RoleDTO {
  private String name;
  private Roles role;
}
