package br.com.compasso.cooperativismo.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<EnumValidation, String> {

	 

    private EnumValidation annotation;

 

    @Override
    public void initialize(EnumValidation annotation) {
        this.annotation = annotation;
    }

 

    @Override
    public boolean isValid(String valueForValidation, ConstraintValidatorContext constraintValidatorContext) {
        Object[] enumValues = this.annotation.enumClass().getEnumConstants();
        return validate(valueForValidation, enumValues);
    }

 

    private boolean validate(String valueForValidation, Object[] enumValues) {
        boolean result = false;
        
        if ((valueForValidation.isEmpty() ) || (enumValues == null)) {
            return result;
        }

 

        for (Object enumValue : enumValues) {
            if (isValid(valueForValidation, enumValue)) {
                result = true;
                break;
            }
        }

 

        return result;
    }

 

    private boolean isValid(String valueForValidation, Object enumValue) {
        return isEquals(valueForValidation, enumValue);
    }

 

    private boolean isEquals(String valueForValidation, Object enumValue) {
        return valueForValidation.equals(enumValue.toString());
    }

 

}
