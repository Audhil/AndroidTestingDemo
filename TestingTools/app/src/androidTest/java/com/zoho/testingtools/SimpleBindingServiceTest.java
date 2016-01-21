package com.zoho.testingtools;

import android.content.Intent;
import android.os.IBinder;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ServiceTestRule;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.TimeoutException;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleBindingServiceTest {

    private static final String TAG = "audhil:" + SimpleBindingServiceTest.class.getSimpleName();

    @Rule
    public ServiceTestRule mServiceRule = new ServiceTestRule();

    @Test
    public void checkBoundService() throws TimeoutException {
        Intent serviceIntent = new Intent(InstrumentationRegistry.getTargetContext(), SimpleBindingService.class);
        serviceIntent.putExtra(SimpleBindingService.SEED_KEY, 42L);
        IBinder binder = mServiceRule.bindService(serviceIntent);   //  getting binder
        SimpleBindingService service = ((SimpleBindingService.SimpleBinder) binder).getServiceInstance();   //  getting service
        Log.d(TAG, "checkBoundService : getRandomIntFromService : " + service.getRandomIntFromService());
        assertThat(service.getRandomIntFromService(), is(any(Integer.class)));
    }
}