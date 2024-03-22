package com.learning.passwordvalidator.validator.chain;

public class CharacterLengthConstraintHandler extends PasswordValidatorHandler {

    @Override
    public boolean validate(String password) {
        return password.length() >= 8;
    }

    @Override
    public String getErrorMessage() {
        return "Password must be at least 8 characters long";
    }

}
