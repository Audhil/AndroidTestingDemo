package com.zoho.testingtools;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MainActivityMockitoUnitTest {

    private static final String TAG = MainActivityMockitoUnitTest.class.getSimpleName();

    private static final String FAKE_STRING = "HeyThisIsAFakeString";

    @Mock
    Context context;

    @Before
    public void setUp() {
        System.out.println(TAG + " : setUp");
    }

    @Test
    public void checkContextResourceWithMockito() {
        when(context.getString(R.string.testingString))
                .thenReturn(FAKE_STRING);
        String actual = context.getString(R.string.testingString);
        assertEquals(FAKE_STRING, actual);
        System.out.println(TAG + " : checkContextResourceWithMockito");
    }
}