package com.example.demo.data;

import com.example.demo.data.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
  UserEntity findByName(String name);

  List<UserEntity> findAllByCreatedAtAfter(Date createdAtAfter);
}
