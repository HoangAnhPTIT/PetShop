package com.example.demo.DTO.ResponseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class UserResponse extends BaseResponse {

  public String jwtToken;

  public UserResponse(String jwtToken, String message, boolean success) {
    super(message, success);
    this.jwtToken = jwtToken;
  }
  
}
