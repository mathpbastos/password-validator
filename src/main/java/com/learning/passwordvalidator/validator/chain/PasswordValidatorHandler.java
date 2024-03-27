package com.learning.passwordvalidator.validator.chain;

import java.util.List;

public abstract class PasswordValidatorHandler {

    private PasswordValidatorHandler nextHandler;

    public final void setNextHandler(PasswordValidatorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public final void verifyPassword(String password, List<String> errors) {
        if (!this.validate(password)) {
            errors.add(this.getErrorMessage());
        }
        if(this.nextHandler != null)
            this.nextHandler.verifyPassword(password, errors);
    }

    public abstract boolean validate(String password);

    public abstract String getErrorMessage();

}
