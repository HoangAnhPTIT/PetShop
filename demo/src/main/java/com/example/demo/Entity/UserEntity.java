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

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@RequiredArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "fullname")
  private String fullName;

  @Column(name = "username")
  private String userName;

  @Column(name = "password")
  private String password;

  @Column(name = "address")
  private String address;

  @Column(name = "age")
  private int age;

  @Column(name = "gender")
  private String gender;

  @Column(name = "email")
  private String email;

  @Column(name = "tel")
  private String tel;

  @Column(name = "point")
  private Long point;

  @ManyToMany(mappedBy = "roleUsers")
  private List<RoleEntity> userRoles;

  @OneToMany(mappedBy = "userEntity")
  private List<CartEntity> cartEntities;

  @OneToMany(mappedBy = "userEntity")
  private List<UserVoucher> userVouchers;
}
