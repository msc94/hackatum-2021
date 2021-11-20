package com.example.co2reductionapp;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.co2reductionapp.backend.Backend;
import com.example.co2reductionapp.backend.User;
import com.example.co2reductionapp.backend.activities.Activity;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
        mPager.setCurrentItem(2);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mPager);

        List<User> users = Backend.getUsers(getResources());
        for (User user : users) {
            Log.i("Backend", "User: " + user.getName());
            for (Activity activity: user.getActivities()) {
                Log.i("Backend", "Activity: " + activity.getDescription() + " on " + activity.getDatePublished());
            }
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentPagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ActivitiesFragment();
                case 1:
                    return new LeaderboardFragment();
                case 2:
                    return new ProfileFragment();
                default:
                    throw new UnsupportedOperationException();
            }

        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Activities";
                case 1:
                    return "Leaderboard";
                case 2:
                    return "Profile";
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}