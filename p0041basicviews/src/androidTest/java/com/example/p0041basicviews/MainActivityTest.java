package com.example.p0041basicviews;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.Context;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule public ActivityScenarioRule activityTestRule =
            new ActivityScenarioRule(MainActivity.class);

    @Test
    public void test_isActivityInView() {
        onView(withId(R.id.main)).check(matches(isDisplayed()));
    }

    @Test
    public void test_visibility_title() {

        closeSoftKeyboard();

        onView(withId(R.id.textView)).check(matches(isDisplayed()));

        onView(withId(R.id.checkBox)).check(matches(isDisplayed()));

        onView(withId(R.id.button))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.button2))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

        onView(withId(R.id.button3))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }


    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.p0041basicviews", appContext.getPackageName());
    }

}