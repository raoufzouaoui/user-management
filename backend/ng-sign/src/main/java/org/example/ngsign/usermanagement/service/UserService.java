package org.example.ngsign.usermanagement.service;


import org.example.ngsign.usermanagement.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto save(UserDto dto);

    UserDto findById(Long id);

    List<UserDto> findAll();

    UserDto findByEmail(String email);




}
