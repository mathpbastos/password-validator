package com.learning.passwordvalidator.validator.chain;

import java.util.regex.Pattern;

public class SpecialCharacterConstraintHandler extends PasswordValidatorHandler {

    @Override
    public boolean validate(String password) {
        return Pattern.compile("[^A-Za-z0-9 ]")
                .matcher(password)
                .find();
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least 1 special character";
    }
}
