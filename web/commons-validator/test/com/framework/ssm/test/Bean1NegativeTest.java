package com.framework.ssm.test;

import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.framework.ssm.validation.exception.BeanValidationFailedException;

/**
 * A test class for testing negative scenario.
 * 
 * @author Debadatta Mishra (PIKU)
 * 
 */
public class Bean1NegativeTest {
	private static Bean1 bean = null;

	/**
	 * This method is used to setup the object and populate the test data
	 * 
	 */
	@BeforeClass
	public static void setup() {
		bean = new Bean1();
		bean.setAge(112);
		bean.setZipCode("12334");
		bean.setFirstName(null);
		bean.setAmount(12.345f);
		bean.setEmailId("abcd@");
		bean.setWebsite("wwww.google.");
		bean.setPassword("welcome");
		bean.setIbanActNo("AR1601101250000000012300695");
	}

	/**
	 * This method is used to clean up the data
	 * 
	 */
	@AfterClass
	public static void tearDown() {
		bean = null;
	}

	/**
	 * This method is used to test the negative test cases
	 * 
	 */
	@Test
	public void testNegative() {
		int noOfViolations = 0;
		try {
			ValidatorFactory factory = Validation
					.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Bean1>> set = validator.validate(bean);
			noOfViolations = set.size();
			if (noOfViolations != 0)
				throw new BeanValidationFailedException(set);
		} catch (BeanValidationFailedException e) {
			System.err.println("Total no of violations : " + noOfViolations);
			System.err.println(e.getMessage());
			System.err.println("No of violations : " + noOfViolations);
			assertFalse(false);
		}
	}
}
