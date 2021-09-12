package com.creator.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class UserDTO {

  public interface New {

  }

  public interface Exist {

  }

  public interface UpdatePassword extends Exist {

  }

  public interface UpdateEmail extends Exist {

  }

  @Null(message = "id must be null", groups = {New.class})
  @NotNull(message = "id mustn't be null", groups = {Exist.class})
  private int id;

  @Null(message = "username must be null", groups = {Exist.class})
  @NotNull(message = "username mustn't be null", groups = {New.class})
  private String username;

  @Null(message = "email must be null", groups = {UpdatePassword.class})
  @NotNull(message = "email mustn't be null", groups = {New.class, UpdateEmail.class})
  private String email;

  @Null(message = "password must be null", groups = {UpdateEmail.class})
  @NotNull(message = "password mustn't be null", groups = {New.class, UpdatePassword.class})
  private String password;

  @NotNull(message = "password mustn't be null", groups = {New.class})
  private String role;


  public UserDTO(Integer id, String username, String lastName, String email, String password) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
  }
}
