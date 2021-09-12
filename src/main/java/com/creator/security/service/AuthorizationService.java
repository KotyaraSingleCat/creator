package com.creator.security.service;

import com.creator.dao.AuthRole;
import com.creator.dao.Role;
import com.creator.dao.User;
import com.creator.dto.UserDTO;
import com.creator.security.repository.AuthorizationJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
  @Autowired
  private AuthorizationJPARepository authorizationJPARepository;


  @Autowired
  private PasswordEncoder passwordEncoder;


  public User createUser(UserDTO dto) {
    User user = new User();
    user.setEmail(dto.getEmail());
    user.setPassword(passwordEncoder.encode(dto.getPassword()));
    user.setUsername(dto.getUsername());
    user.setRole(AuthRole.valueOf("ROLE_" + Role.valueOf(dto.getRole())));
    return authorizationJPARepository.save(user);
  }

  public User findByLogin(String email) {
    return authorizationJPARepository.findByEmail(email);
  }

  public User findByLoginAndPassword(String email, String password) {
    User user = findByLogin(email);
    if (user != null) {
      if (passwordEncoder.matches(password, user.getPassword())) {
        return user;
      }
    }
    return null;
  }
}
