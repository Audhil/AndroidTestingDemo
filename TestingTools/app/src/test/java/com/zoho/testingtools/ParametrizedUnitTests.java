package com.zoho.testingtools;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParametrizedUnitTests {

    private static final String TAG = ParametrizedUnitTests.class.getSimpleName();

    @Parameterized.Parameters
    public static Iterable<String> data() {
        return Arrays.asList("level", "liril", "hindi", "malayalam");
    }

    private String text;

    private MainActivity activity;

    public ParametrizedUnitTests(String text) {
        this.text = text;
    }

    @Before
    public void setUp() {
        activity = new MainActivity();
        System.out.println(TAG + " : ParametrizedUnitTestsSetUp");
    }

    @Test
    public void palindromChecker() {
        boolean result = activity.checkPalindrome(text); //  liril, mom, malayalam
        assertEquals(true, result);
        System.out.println(TAG + " : ParametrizedUnitTestsPalindromeChecker");
    }
}
