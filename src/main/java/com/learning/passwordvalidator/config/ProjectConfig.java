package com.learning.passwordvalidator.config;

import com.learning.passwordvalidator.validator.chain.*;
import com.learning.passwordvalidator.validator.service.PasswordValidatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    public PasswordValidatorService passwordValidatorService() {
        PasswordValidatorService passwordValidatorService = new PasswordValidatorService();

        passwordValidatorService.addPasswordHandler(new CharacterLengthConstraintHandler());
        passwordValidatorService.addPasswordHandler(new UpperCaseConstraintHandler());
        passwordValidatorService.addPasswordHandler(new LowerCaseConstraintHandler());
        passwordValidatorService.addPasswordHandler(new NumberConstraintHandler());
        passwordValidatorService.addPasswordHandler(new SpecialCharacterConstraintHandler());

        return passwordValidatorService;
    }

}
