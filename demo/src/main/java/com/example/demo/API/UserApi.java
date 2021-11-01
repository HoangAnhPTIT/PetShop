package com.example.demo.API;

import com.example.demo.DTO.UserDTO;
import com.example.demo.DTO.ResponseDTO.UserResponse;
import com.example.demo.Service.Implement.JwtUserDetailsService;
import com.example.demo.Utils.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
  
  @Autowired
	private AuthenticationManager authenticationManager;

  @Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
  
  @PostMapping("/user/register")
  @ResponseBody
  public UserResponse register(@RequestBody UserDTO userDTO){
    return null;
  }

  @GetMapping(value = "/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {

    String username = userDTO.getUsername();
    String password = userDTO.getPassword() ;
		authenticate(username, password);

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(userDTO.getUsername());
        

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new UserResponse(token, "Success", true));
	}

  private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
