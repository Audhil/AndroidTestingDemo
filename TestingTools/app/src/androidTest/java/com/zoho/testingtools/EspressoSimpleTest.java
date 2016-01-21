package com.zoho.testingtools;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

//  new style

@RunWith(AndroidJUnit4.class)
public class EspressoSimpleTest {

    private static final String STRING_TO_BE_DISPLAYED = "Jack and jill went up the hill to fetch a pail of water!";

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkTextChangeInSameActivity() {
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_DISPLAYED), closeSoftKeyboard());
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.editText)).check(matches(withText(STRING_TO_BE_DISPLAYED)));
    }

    @Test
    public void checkTextChangeInSecondActivity() {
        onView(withId(R.id.editText)).perform(typeText(STRING_TO_BE_DISPLAYED), closeSoftKeyboard());
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.screenTwoTxtView)).check(matches(withText(STRING_TO_BE_DISPLAYED)));
    }
}