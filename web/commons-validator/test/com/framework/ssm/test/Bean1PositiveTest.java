package com.framework.ssm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
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
 * Test class for positive test cases
 * 
 * @author Debadatta Mishra (PIKU)
 * 
 */
public class Bean1PositiveTest {
	private static Bean1 bean = null;

	/**
	 * This method is used to setup the object and populate the test data
	 * 
	 */
	@BeforeClass
	public static void setup() {
		bean = new Bean1();
		bean.setAge(19);
		bean.setZipCode("123345");
		bean.setFirstName("Debadatta");
		bean.setAmount(12.43f);
		bean.setEmailId("debadatta.mishra@gmail.com");
		bean.setWebsite("http://www.google.com");
		bean.setPassword("passWord@11");
		bean.setIbanActNo("CH9300762011623852957");
		bean.setSurName("Mishra");
		List<String> visitedCountryList = new ArrayList<String>();
		visitedCountryList.add("Denmark");
		visitedCountryList.add("Norway");
		visitedCountryList.add("Finland");
		visitedCountryList.add("Latvia");
		visitedCountryList.add("Lithuania");
		visitedCountryList.add("France");
		bean.setCountryList(visitedCountryList);
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
	 * This method is used to test the positive test cases
	 * 
	 */
	@Test
	public void testPositive() {
		int noOfViolations = 0;
		try {
			ValidatorFactory factory = Validation
					.buildDefaultValidatorFactory();
			Validator validator = factory.getValidator();
			Set<ConstraintViolation<Bean1>> set = validator.validate(bean);
			noOfViolations = set.size();
			assertEquals(0, noOfViolations);
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
