package com.framework.ssm.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This class provides an implementation for the validation of IBAN number.
 * <p>
 * IBAN number is International Bank Account Number. For more details refer <a
 * href="http://en.wikipedia.org/wiki/International_Bank_Account_Number">IBAN in Wikipedia</a>
 * 
 * @author <a href="mailto:debadatta.mishra@gmail.com"> Debadatta Mishra (PIKU)
 * @since Sep 2012
 */
public class IBANValidator implements ConstraintValidator<IBAN, String> {
    
    private static final long MAX = 999999999;
    
    private static final long MODULUS = 97;
    
    public void initialize(IBAN arg0) {
        
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see javax.validation.ConstraintValidator#isValid(java.lang.Object,
     * javax.validation.ConstraintValidatorContext) GR1601101250000000012300695;
     * //Correct IBAN Number AR1601101250000000012300695;//Wrong IBAN Number
     * CH9300762011623852957;//Correct IBAN Number
     */
    public boolean isValid(String str, ConstraintValidatorContext context) {
        if (str == null || str.length() < 5) {
            return false;
        }
        try {
            int modulusResult = calculateModulus(str);
            return (modulusResult == 1);
        } catch (Exception ex) {
            return false;
        }
    }
    
    /**
     * This method is used to calculate the final modulo of the given IBAN number.
     * 
     * @param code of type String indicating IBAN number
     * @return number
     * @throws Exception
     */
    private int calculateModulus(String code) throws Exception {
        String reformattedCode = code.substring(4) + code.substring(0, 4);
        long total = 0;
        for (int i = 0; i < reformattedCode.length(); i++) {
            int charValue = Character.getNumericValue(reformattedCode.charAt(i));
            if (charValue < 0 || charValue > 35) {
                throw new Exception("Invalid Character[" + i + "] = '" + charValue + "'");
            }
            total = (charValue > 9 ? total * 100 : total * 10) + charValue;
            if (total > MAX) {
                total = (total % MODULUS);
            }
        }
        return (int) (total % MODULUS);
    }
    
}