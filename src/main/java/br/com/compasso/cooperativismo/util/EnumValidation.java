package br.com.compasso.cooperativismo.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { EnumValueValidator.class })
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValidation {
    public abstract String message() default "{br.com.compasso.cooperativismo.util.EnumValidation.message}";

 

    public abstract Class<?>[] groups() default {};

 

    public abstract Class<? extends Payload>[] payload() default {};

 

    public abstract Class<? extends java.lang.Enum<?>> enumClass();

 

    public abstract boolean ignoreCase() default false;
}
