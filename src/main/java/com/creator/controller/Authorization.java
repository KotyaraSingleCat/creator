package com.creator.controller;

import com.creator.dao.User;
import com.creator.dto.AuthorizationDTO;
import com.creator.dto.AuthorizationResponse;
import com.creator.dto.UserDTO;
import com.creator.security.jwt.JwtProvider;
import com.creator.security.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Authorization {

  @Autowired
  AuthorizationService authorizationService;
  @Autowired
  private JwtProvider jwtProvider;

  @PostMapping("/authorization")
  public AuthorizationResponse authorization(@RequestBody AuthorizationDTO request){
    User userEntity = authorizationService.findByLoginAndPassword(request.getEmail(), request.getPassword());
    String token = jwtProvider.generateToken(userEntity.getEmail());
    return new AuthorizationResponse(token);
  }

  @PostMapping(path = "/registration")
  public String registration(@RequestBody UserDTO userDTO){
    authorizationService.createUser(userDTO);
    return "OK";
  }

  @GetMapping(path = "/test")
  public String test() {
    return "You can see this! Congratulations!";
  }

}
