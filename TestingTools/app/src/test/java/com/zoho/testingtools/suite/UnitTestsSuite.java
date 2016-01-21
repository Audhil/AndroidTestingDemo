package com.zoho.testingtools.suite;

import com.zoho.testingtools.MainActivityMockitoUnitTest;
import com.zoho.testingtools.MainActivityUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityUnitTest.class, MainActivityMockitoUnitTest.class})
public class UnitTestsSuite {
}