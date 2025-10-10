package com.example.demo.domain;

import com.example.demo.data.UserRepository;
import com.example.demo.data.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Long insert(UserEntity user) {
    UserEntity savedUser = userRepository.save(user);
    return savedUser.getId();
  }

  @Override
  public List<UserEntity> findAll() {
    return (List<UserEntity>) userRepository.findAll();
  }

  @Override
  public UserEntity findByName(String name) {
    return userRepository.findByName(name);
  }
}
