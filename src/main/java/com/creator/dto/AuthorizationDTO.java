package com.creator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@Data
public class AuthorizationDTO {

  @NotNull
  private String email;
  @NotNull
  private String password;
}
