package com.zoho.testingtools;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.Until;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

//  tutorial : http://code.tutsplus.com/tutorials/automating-user-interface-testing-on-android--cms-23969

//public class CalculatorUIAutomaterTest extends InstrumentationTestCase {
//
//    UiDevice device;
//
//    @Override
//    protected void setUp() throws Exception {
//        super.setUp();
//        device = UiDevice.getInstance(getInstrumentation());
//        device.pressHome();
//        device.wait(Until.hasObject(By.desc("Apps")), 3000);
//
//        UiObject2 appsButton = device.findObject(By.desc("Apps"));
//        appsButton.click();
//        device.wait(Until.hasObject(By.text("Calculator")), 3000);
//
//        UiObject2 calculatorApp = device.findObject(By.text("Calculator"));
//        calculatorApp.click();
//    }
//
//    public void testAdd() throws Exception {
//        device.wait(Until.hasObject(By.text("9")), 3000);
//        UiObject2 buttonNine = device.findObject(By.text("9"));
//        buttonNine.click();
//        UiObject2 buttonPlus = device.findObject(By.desc("plus"));
//        buttonPlus.click();
//        buttonNine.click();
//        UiObject2 buttonEquals = device.findObject(By.desc("equals"));
//        buttonEquals.click();
//
//        device.waitForIdle(3000);
//
//        UiObject2 resultText = device.findObject(By.clazz("android.widget.EditText"));
//        String result = resultText.getText();
//        assertTrue(result.equals("18"));
//    }
//}

@RunWith(AndroidJUnit4.class)
public class CalculatorUIAutomaterTest {

    UiDevice device;

    @Before
    public void init() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        device.pressHome();
        device.wait(Until.hasObject(By.desc("Apps")), 3000);

        UiObject2 appsButton = device.findObject(By.desc("Apps"));
        appsButton.click();
        device.wait(Until.hasObject(By.text("Calculator")), 3000);

        UiObject2 calculatorApp = device.findObject(By.text("Calculator"));
        calculatorApp.click();
    }

    @Test
    public void launchCalculatorAndTest() {
        device.wait(Until.hasObject(By.text("9")), 3000);
        UiObject2 buttonNine = device.findObject(By.text("9"));
        buttonNine.click();
        UiObject2 buttonPlus = device.findObject(By.desc("plus"));
        buttonPlus.click();
        buttonNine.click();
        UiObject2 buttonEquals = device.findObject(By.desc("equals"));
        buttonEquals.click();

        device.waitForIdle(3000);

        UiObject2 resultText = device.findObject(By.clazz("android.widget.EditText"));
        String result = resultText.getText();
        assertTrue(result.equals("18"));
    }
}