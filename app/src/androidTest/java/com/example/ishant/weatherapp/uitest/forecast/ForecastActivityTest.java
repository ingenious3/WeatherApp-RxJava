package com.example.ishant.weatherapp.uitest.forecast;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.ishant.weatherapp.R;
import com.example.ishant.weatherapp.forecastactivity.view.ForecastActivity;
import com.example.ishant.weatherapp.utils.Utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.swipeDown;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class ForecastActivityTest {

    @Rule
    public ActivityTestRule<ForecastActivity> forecastActivityTestRule = new ActivityTestRule<ForecastActivity>(ForecastActivity.class) {
        @Override
        protected Intent getActivityIntent() {

            Intent intent = new Intent();
            intent.putExtra("data", Utils.initialize());
            return intent;
        }
    };

    @Test
    public void testCurrentView() {
        onView(withId(R.id.current_temperature))
                .check(matches(withText(Utils.initialize().getCurrent().getTemp_c() + forecastActivityTestRule.getActivity().getString(R.string.degree))));
        onView(withId(R.id.location_view)).check(matches(withText(Utils.initialize().getLocation().getName())));

    }

    @Test
    public void testRecyclerTouch() {
        onView(withId(R.id.forecast_list)).perform(swipeDown());

    }




}
