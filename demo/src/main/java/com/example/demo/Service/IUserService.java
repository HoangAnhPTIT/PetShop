package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.DTO.ResponseDTO.UserResponse;

public interface IUserService {
  public UserResponse register(UserDTO userDTO);
  public UserDTO getUser(UserDTO userDTO);
  public UserResponse login(UserDTO userDTO);
}
