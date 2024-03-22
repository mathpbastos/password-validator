package com.learning.passwordvalidator.validator.service;

import com.learning.passwordvalidator.validator.chain.PasswordValidatorHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class PasswordValidatorService {

    private PasswordValidatorHandler first;
    private PasswordValidatorHandler next;

    public void addPasswordHandler(PasswordValidatorHandler passwordValidatorHandler) {
        if(this.first == null) this.first = passwordValidatorHandler;
        else {
            this.next.setNextHandler(passwordValidatorHandler);
        }

        this.next = passwordValidatorHandler;
    }

    public List<String> validatePassword(String password) {
        this.regenerateErrorsList();
        this.first.verifyPassword(password);

        return this.first.getErrors();
    }

    private void regenerateErrorsList() {
        this.first.setErrors(new ArrayList<String>());
    }

}
