package com.example.demo.presentantion.users.dto;

import com.example.demo.data.entities.UserEntity;
import com.example.demo.domain.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController implements WriteUserController, ReadUserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Override
  @PostMapping("/users")
  public Long createUser(
      @RequestBody
      UserRequest user
  ) {
    UserEntity userEntity = new UserEntity();
    userEntity.setName(user.name());
    userEntity.setEmail(user.email());

    return userService.insert(userEntity);
  }

  @Override
  @GetMapping("/users/{name}")
  public UserResponse getUserByName(
      @PathVariable("name")
      String name
  ) {
    UserEntity userEntity = userService.findByName(name);
    if (userEntity == null) {
      return null;
    }
    return new UserResponse(
        userEntity.getId(),
        userEntity.getName(),
        userEntity.getEmail(),
        userEntity.getCreatedAt().toString()
    );
  }

  @Override
  @GetMapping("/users")
  public UsersResponse getAllUsers() {
    List<UserEntity> users = userService.findAll();
    List<UserResponse> userResponses = users.stream().map(userEntity -> new UserResponse(
        userEntity.getId(),
        userEntity.getName(),
        userEntity.getEmail(),
        userEntity.getCreatedAt().toString()
    )).toList();
    return new UsersResponse(userResponses);
  }
}
