package org.example.ngsign.usermanagement.controller;

import org.example.ngsign.usermanagement.controller.api.UserApi;
import org.example.ngsign.usermanagement.dto.UserDto;
import org.example.ngsign.usermanagement.exception.InvalidEntityException;
import org.example.ngsign.usermanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDto> save(UserDto dto) {
        return ResponseEntity.ok(userService.save(dto));
    }

    @Override
    public ResponseEntity<UserDto> findById(Long id) {
        UserDto user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UserDto> findByEmail(String email) {
        UserDto user = userService.findByEmail(email);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> users = userService.findAll();
        return ResponseEntity.ok(users);
    }
}
