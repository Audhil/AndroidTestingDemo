package com.zoho.testingtools;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class SimpleBindingService extends Service {

    public static final String SEED_KEY = "seedKey";

    IBinder mBinder = new SimpleBinder();

    Random randomGenerator = new Random();

    long mSeed;

    @Override
    public IBinder onBind(Intent intent) {
        if (intent.hasExtra(SEED_KEY)) {
            mSeed = intent.getLongExtra(SEED_KEY, 0);
            randomGenerator.setSeed(mSeed);
        }
        return mBinder;
    }

    //  local binder
    public class SimpleBinder extends Binder {
        public SimpleBindingService getServiceInstance() {
            return SimpleBindingService.this;
        }
    }

    //  getting random integer in [0,100)
    public int getRandomIntFromService() {
        return randomGenerator.nextInt(100);
    }
}