package org.example.ngsign.usermanagement.service.impl;

import org.example.ngsign.usermanagement.dto.UserDto;
import org.example.ngsign.usermanagement.entity.User;
import org.example.ngsign.usermanagement.exception.EntityNotFoundException;
import org.example.ngsign.usermanagement.exception.ErrorCodes;
import org.example.ngsign.usermanagement.exception.InvalidEntityException;
import org.example.ngsign.usermanagement.repository.UserRepository;
import org.example.ngsign.usermanagement.service.UserService;
import org.example.ngsign.usermanagement.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto save(UserDto dto) {
        System.out.println(dto);
        List<String> errors = UserValidator.validate(dto);
        System.out.println(errors);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("L'utilisateur n'est pas valide", ErrorCodes.UTILISATEUR_NOT_VALID, errors);
        }

        if(userAlreadyExists(dto.getEmail())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme email existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme email existe deja dans la BDD"));
        }

        if(phoneAlreadyExists(dto.getPhone())) {
            throw new InvalidEntityException("Un autre utilisateur avec le meme numéro de téléphone existe deja", ErrorCodes.UTILISATEUR_ALREADY_EXISTS,
                    Collections.singletonList("Un autre utilisateur avec le meme numéro de téléphone existe deja dans la BDD"));
        }

        return UserDto.fromEntity(
                userRepository.save(
                        UserDto.toEntity(dto)
                )
        );
    }


    private boolean userAlreadyExists(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.isPresent();
    }

    private boolean phoneAlreadyExists(String phone) {
        Optional<User> user = userRepository.findUserByPhone(phone);
        return user.isPresent();
    }

    @Override
    public UserDto findById(Long id) {
        if (id == null) {
            return null;
        }
        return userRepository.findById(id)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'ID = " + id + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }



    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findUserByEmail(email)
                .map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Aucun utilisateur avec l'email = " + email + " n' ete trouve dans la BDD",
                        ErrorCodes.UTILISATEUR_NOT_FOUND)
                );
    }

}
