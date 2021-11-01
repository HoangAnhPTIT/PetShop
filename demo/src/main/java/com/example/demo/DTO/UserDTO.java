package com.example.demo.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class UserDTO {
  private String username;
  private String password;
  private String fullName;
  private String address;
  private int age;
  private String gender;
  private String email;
  private String tel;
  private Long point;

  private List<RoleDTO> userRoles;

}
