package org.example.ngsign.usermanagement.controller.api;

import org.example.ngsign.usermanagement.dto.UserDto;
import org.example.ngsign.usermanagement.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserApi {

    @PostMapping(Constants.UTILISATEUR_ENDPOINT + "/create")
    ResponseEntity<UserDto> save(@RequestBody UserDto dto); // Updated return type

    @GetMapping(Constants.UTILISATEUR_ENDPOINT + "/find/id/{id}")
    ResponseEntity<UserDto> findById(@PathVariable("id") Long id); // Updated return type

    @GetMapping(Constants.UTILISATEUR_ENDPOINT + "/find/email/{email}")
    ResponseEntity<UserDto> findByEmail(@PathVariable("email") String email); // Updated return type

    @GetMapping(Constants.UTILISATEUR_ENDPOINT + "/find/all")
    ResponseEntity<List<UserDto>> findAll(); // Updated return type
}
