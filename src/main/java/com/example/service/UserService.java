package com.example.service;

import org.springframework.http.ResponseEntity;

public interface UserService {

  public ResponseEntity<?> fetchUsers(Integer pageNo, Integer pageSize);

  public ResponseEntity<?> createUser(String name);
}
