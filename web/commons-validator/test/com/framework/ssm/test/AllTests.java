package com.framework.ssm.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Suite class
 * 
 * @author Debadatta Mishra (PIKU)
 * 
 */
@RunWith(Suite.class)
@SuiteClasses({ Bean1NegativeTest.class, Bean1PositiveTest.class })
public class AllTests {

}