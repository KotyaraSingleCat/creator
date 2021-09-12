package com.creator.security.service;

import com.creator.dao.User;
import com.creator.security.UserCustomDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserCustomDetailsService implements UserDetailsService {
  @Autowired
  private AuthorizationService service;

  @Override
  public UserCustomDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User userEntity = service.findByLogin(username);
    return UserCustomDetails.fromUserEntityToCustomUserDetails(userEntity);
  }
}
