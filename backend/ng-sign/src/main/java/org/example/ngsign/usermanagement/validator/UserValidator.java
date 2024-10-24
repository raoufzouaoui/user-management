package org.example.ngsign.usermanagement.validator;


import java.util.ArrayList;
import java.util.List;

import org.example.ngsign.usermanagement.dto.UserDto;
import org.springframework.util.StringUtils;

public class UserValidator {

    public static List<String> validate(UserDto userDto) {
        System.out.println(userDto);
        List<String> errors = new ArrayList<>();

        if (userDto == null) {
            errors.add("Veuillez renseigner l'utilisateur.");
            return errors;
        }

        if (!StringUtils.hasLength(userDto.getFirstName())) {
            errors.add("Veuillez renseigner le prénom de l'utilisateur.");
        }
        if (!StringUtils.hasLength(userDto.getLastName())) {
            errors.add("Veuillez renseigner le nom de l'utilisateur.");
        }
        if (!StringUtils.hasLength(userDto.getEmail())) {
            errors.add("Veuillez renseigner l'email de l'utilisateur.");
        }
        if (!StringUtils.hasLength(userDto.getPhone())) {
            errors.add("Veuillez renseigner le numéro de téléphone de l'utilisateur.");
        }
        if (userDto.getDateOfBirth() == null) {
            errors.add("Veuillez renseigner la date de naissance de l'utilisateur.");
        }
        if (!StringUtils.hasLength(userDto.getImageUrl())) {
            errors.add("Veuillez renseigner l'URL de l'image de l'utilisateur.");
        }
        if (!StringUtils.hasLength(userDto.getProfession())) {
            errors.add("Veuillez renseigner le profession de l'utilisateur.");
        }
        return errors;
    }
}
