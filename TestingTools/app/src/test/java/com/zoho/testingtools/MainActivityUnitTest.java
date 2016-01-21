package com.zoho.testingtools;

import android.test.suitebuilder.annotation.SmallTest;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//  junit 4
public class MainActivityUnitTest {

    private static final String TAG = MainActivityUnitTest.class.getSimpleName();

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = new MainActivity();
        System.out.println(TAG + " : UnitTestsetUp");
    }

    @Test
    public void palindromChecker() {
        boolean result = activity.checkPalindrome("LEVEL"); //  liril, mom, malayalam
        assertEquals(true, result);
        System.out.println(TAG + " : UnitTestPalindrome");
    }
}

//  junit 3
//public class MainActivityUnitTest extends TestCase {
//
//    private MainActivity activity;
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        activity = new MainActivity();
//        System.out.println("audhil:setUp");
//    }
//
//    @Override
//    protected void tearDown() throws Exception {
//        super.tearDown();
//        System.out.println("audhil:tearDown");
//    }
//
//    @Test
//    public void testPalindromChecker() {
//        System.out.println("audhil:testPalindrome");
//        boolean result = activity.checkPalindrome("LEVEL"); //  liril, mom, malayalam
//        assertEquals(true, result);
//    }
//}