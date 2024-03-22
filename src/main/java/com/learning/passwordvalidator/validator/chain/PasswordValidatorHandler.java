package com.learning.passwordvalidator.validator.chain;

import java.util.ArrayList;
import java.util.List;

public abstract class PasswordValidatorHandler {

    private PasswordValidatorHandler nextHandler;

    private static List<String> errors;

    public final void setNextHandler(PasswordValidatorHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public final void verifyPassword(String password) {
        if (!this.validate(password)) {
            addError(this.getErrorMessage());
        }
        if(this.nextHandler != null)
            this.nextHandler.verifyPassword(password);
    }

    public abstract boolean validate(String password);

    public abstract String getErrorMessage();

    public final void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public final List<String> getErrors() {
        return errors;
    }

    private final void addError(String error) {
        if(errors == null) this.errors = new ArrayList<>();
        errors.add(error);
    }
}
