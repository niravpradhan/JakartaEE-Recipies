package org.jakartaeerecipes.chapter03c.annotation;

/**
 * Custom validation annotation for validating passwords to ensure that they
 * meet the criteria.
 *
 * @author juneau
 */

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.jakartaeerecipes.chapter03c.validator.CheckPasswordValidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckPasswordValidator.class)
@Documented
public @interface PasswordLength {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String message() default "{org.javaee8recipes.constraints.password}";

    /**
     * @return password length
     */
    int passwordLength();

}
