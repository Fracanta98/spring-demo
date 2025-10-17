package com.example.demo.presentantion.users.dto;

public interface ReadUserController {
  UserResponse getUserByName(String name);
  UsersResponse getAllUsers();
}
