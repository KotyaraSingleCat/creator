package com.creator.security.repository;

import com.creator.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationJPARepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
}
