package com.example.demo.Service.Implement;

import java.util.ArrayList;
import java.util.Collections;

import com.example.demo.DTO.UserDTO;
import com.example.demo.DTO.ResponseDTO.UserResponse;
import com.example.demo.Entity.RoleEntity;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Entity.EnumType.Roles;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.IUserService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService implements IUserService {

  @Autowired
  private ModelMapper mapper;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserResponse register(UserDTO userDTO) {
    UserEntity userEntity = mapper.map(userDTO, UserEntity.class);
    RoleEntity roleEntity = getDefaultRole();
    userEntity.setUserRoles(Collections.singletonList(roleEntity));
    try {
      userRepository.save(userEntity);
    } catch (Exception e) {
      //TODO: handle exception
    }
    return null;
  }

  @Override
  public UserDTO getUser(UserDTO userDTO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserResponse login(UserDTO userDTO) {
    // TODO Auto-generated method stub
    return null;
  }
  
  private RoleEntity getDefaultRole(){
    RoleEntity roleEntity = roleRepository.findByrole(Roles.USER);
    return roleEntity;
  }

}
