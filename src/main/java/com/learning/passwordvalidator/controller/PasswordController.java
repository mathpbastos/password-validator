package com.learning.passwordvalidator.controller;

import com.learning.passwordvalidator.model.Password;
import com.learning.passwordvalidator.model.PasswordRequestDTO;
import com.learning.passwordvalidator.validator.service.PasswordValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/password")
public class PasswordController {

    @Autowired
    private PasswordValidatorService passwordValidatorService;

    @PostMapping("/verify")
    public ResponseEntity<List<String>> validatePassword(@RequestBody PasswordRequestDTO passwordRequestDTO) {
        List<String> errors = this.passwordValidatorService.validatePassword(
                passwordRequestDTO.password(), new ArrayList<>());

        if(!errors.isEmpty())
            return ResponseEntity.badRequest().body(errors);

        return ResponseEntity.noContent().build();
    }


}
