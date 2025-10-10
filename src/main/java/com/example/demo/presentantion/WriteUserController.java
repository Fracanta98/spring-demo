package com.example.demo.presentantion;

import com.example.demo.presentantion.dto.UserRequest;

public interface WriteUserController {
  Long createUser(UserRequest user);
}
