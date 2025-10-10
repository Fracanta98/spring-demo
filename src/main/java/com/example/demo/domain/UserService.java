package com.example.demo.domain;

import com.example.demo.data.entities.UserEntity;

import java.util.List;

public interface UserService {
  Long insert(UserEntity user);
  List<UserEntity> findAll();
  UserEntity findByName(String name);
}
