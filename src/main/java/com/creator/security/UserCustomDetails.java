package com.creator.security;

import com.creator.dao.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserCustomDetails implements UserDetails {
  private String email;
  private String password;
  private Collection<? extends GrantedAuthority> grantedAuthorities;

  public static UserCustomDetails fromUserEntityToCustomUserDetails(User userEntity) {
    UserCustomDetails c = new UserCustomDetails();
    c.email = userEntity.getEmail();
    c.password = userEntity.getPassword();
    c.grantedAuthorities = Collections.singletonList(new SimpleGrantedAuthority(userEntity.getRole().toString()));
    return c;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return grantedAuthorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
