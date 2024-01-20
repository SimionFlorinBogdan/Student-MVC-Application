package sudentapplication.student.app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RegistrationCodeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RegistrationCode {

    public String [] value() default {"TAX", "SFS"};

    public String message() default "invalid registration code";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
