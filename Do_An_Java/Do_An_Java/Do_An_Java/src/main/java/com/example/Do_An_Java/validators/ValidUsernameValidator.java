package com.example.Do_An_Java.validators;


import com.example.Do_An_Java.services.UserService;
import com.example.Do_An_Java.validators.annotation.ValidUsername;

import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    private final UserService userService;
    @Override
    public boolean isValid(String username , ConstraintValidatorContext context) {
        return userService.findByUsername(username).isEmpty();
    }
}