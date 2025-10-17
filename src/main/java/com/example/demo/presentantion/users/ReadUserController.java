package com.example.demo.presentantion.users;

import com.example.demo.presentantion.users.dto.UserResponse;
import com.example.demo.presentantion.users.dto.UsersResponse;

public interface ReadUserController {
  UserResponse getUserByName(String name);
  UsersResponse getAllUsers();
}
