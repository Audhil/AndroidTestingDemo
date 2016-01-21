package com.zoho.testingtools.suite;

import com.zoho.testingtools.EspressoSimpleTest;
import com.zoho.testingtools.MainActivityTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({MainActivityTest.class, EspressoSimpleTest.class})
public class InstrumentedUnitTestsSuite {
}