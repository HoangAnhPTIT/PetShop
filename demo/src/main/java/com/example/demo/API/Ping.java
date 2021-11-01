package com.example.demo.API;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ping {
@RequestMapping(value = "/ping", method = RequestMethod.GET)
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>("Ok", HttpStatus.OK);
   }
}
