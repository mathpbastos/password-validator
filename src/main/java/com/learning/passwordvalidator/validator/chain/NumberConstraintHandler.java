package com.learning.passwordvalidator.validator.chain;

public class NumberConstraintHandler extends PasswordValidatorHandler {

    @Override
    public boolean validate(String password) {
        return password.chars()
                .filter(Character::isDigit)
                .findFirst()
                .isPresent();
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least 1 number";
    }
}
