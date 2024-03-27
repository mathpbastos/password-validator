package com.learning.passwordvalidator.model;

import java.util.List;

public record PasswordResponseDTO(
        List<String> errors
) {
}
