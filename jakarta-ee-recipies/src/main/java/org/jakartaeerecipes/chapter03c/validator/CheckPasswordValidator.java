package org.jakartaeerecipes.chapter03c.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.jakartaeerecipes.chapter03c.annotation.PasswordLength;

/**
 * Custom validation class to ensure password is long enough
 *
 * @author juneau
 */
public class CheckPasswordValidator implements
        ConstraintValidator<PasswordLength, Object> {
    private int passwordLength;

    private String password;

    @Override
    public void initialize(PasswordLength constraintAnnotation) {
        // Initilize implementation here
        passwordLength = constraintAnnotation.passwordLength();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean returnValue = false;
        if (value.toString().length() >= passwordLength) {
            returnValue = true;
        } else {
            returnValue = false;
        }
        return returnValue;
    }

}
