package com.zoho.testingtools;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//  old style
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private static final String TAG = "audhil:" + MainActivityTest.class.getSimpleName();
    MainActivity activity;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
        Log.d(TAG, "setUp: called");
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        Log.d(TAG, "tearDown: called");
    }

    @SmallTest
    public void testActivityExists() {
        assertNotNull(activity);
    }

    @SmallTest
    public void testGreet() {
        final EditText editText = (EditText) activity.findViewById(R.id.editText);
        Button button = (Button) activity.findViewById(R.id.button);
        TextView textView = (TextView) activity.findViewById(R.id.textView);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                editText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("jack and jill");
        TouchUtils.clickView(this, button);
        String actualText = textView.getText().toString();
        assertEquals("Hello, jack and jill !", actualText);
    }

    @SmallTest
    public void testSecondActivityLaunch() {
        Button button = (Button) activity.findViewById(R.id.button2);
        TouchUtils.clickView(this, button);
    }
}