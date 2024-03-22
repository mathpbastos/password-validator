package com.learning.passwordvalidator.validator.chain;

public class LowerCaseConstraintHandler extends PasswordValidatorHandler {

    @Override
    public boolean validate(String password) {
        return password.chars()
                .filter(Character::isLowerCase)
                .findFirst()
                .isPresent();
    }

    @Override
    public String getErrorMessage() {
        return "Password must contain at least 1 lower case character";
    }
}
