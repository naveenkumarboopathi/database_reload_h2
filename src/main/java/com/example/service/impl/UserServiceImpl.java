package com.example.service.impl;

import com.example.entity.Users;
import com.example.repository.UserRepository;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private CacheManager cacheManager;

    //in future may be need add pagination
    @Override
    public ResponseEntity<?> fetchUsers(Integer pageNo, Integer pageSize) {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createUser(String name) {
        Users user = new Users(name);
        userRepository.save(user);
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }
}
