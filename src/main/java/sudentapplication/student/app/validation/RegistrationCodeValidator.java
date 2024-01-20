package sudentapplication.student.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RegistrationCodeValidator implements ConstraintValidator<RegistrationCode, String> {

    private String codePrefix1;
    private String codePrefix2;

    @Override
    public void initialize(RegistrationCode theCode){

        try {
            codePrefix1 = theCode.value()[0];
            codePrefix2 = theCode.value()[1];
        }
        catch (IndexOutOfBoundsException e)  {
            throw new RuntimeException("Only two prefixes allowed");
        }
    }

    @Override
    public boolean isValid(String theInput, ConstraintValidatorContext constraintValidatorContext) {

        if(theInput.length() != 6){
            return false;
        }

        boolean result;

        result = theInput.substring(0, 3).equals(codePrefix1) || theInput.substring(0, 3).equals(codePrefix2);

        for(int i = 3; i <= 5; i++){
            if(!Character.isDigit(theInput.charAt(i))){
                return false;
            }
        }

        return result;
    }
}
