package com.example.demo.presentantion;

import com.example.demo.presentantion.dto.UserResponse;
import com.example.demo.presentantion.dto.UsersResponse;

public interface ReadUserController {
  UserResponse getUserByName(String name);
  UsersResponse getAllUsers();
}
