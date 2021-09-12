package com.creator.dao;

import org.springframework.security.core.GrantedAuthority;

public enum Role {
  ADMIN,
  MODERATOR,
  SPONSOR,
  CUSTOM;
}
