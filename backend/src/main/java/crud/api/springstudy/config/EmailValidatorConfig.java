package crud.api.springstudy.config;


import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailValidatorConfig {

    @Bean
    public EmailValidator emailValidator() {
        return EmailValidator.getInstance();
    }
}
