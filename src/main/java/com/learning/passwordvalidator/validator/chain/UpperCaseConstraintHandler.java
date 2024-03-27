package com.learning.passwordvalidator.validator.chain;

public class UpperCaseConstraintHandler extends PasswordValidatorHandler {

    @Override
    public boolean validate(String password) {
        return password.chars()
                .filter(Character::isUpperCase)
                .findFirst()
                .isPresent();
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least 1 uppercase character";
    }

}
