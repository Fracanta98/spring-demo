package com.example.demo.presentantion.users;

import com.example.demo.presentantion.users.dto.UserRequest;

public interface WriteUserController {
  Long createUser(UserRequest user);
}
