package com.example.ishant.weatherapp.uitest.splash;

import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ishant.weatherapp.R;
import com.example.ishant.weatherapp.splashactivity.view.SplashActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.ishant.weatherapp.utils.Utils.isConnected;

@RunWith(AndroidJUnit4.class)
public class SplashActivityTest {

    @Rule
    public ActivityTestRule<SplashActivity> mActivityRule = new ActivityTestRule<>(
            SplashActivity.class);


    @Test
    public void testProgressbar() {

        if (isConnected(mActivityRule.getActivity())) {
            onView(withId(R.id.imgv_progress))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            onView(withId(R.id.retry_button))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
            onView(withId(R.id.error_textview))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
        else
        {
            onView(withId(R.id.retry_button))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
            onView(withId(R.id.error_textview))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));

            onView(withId(R.id.imgv_progress))
                    .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
        }
    }



}
