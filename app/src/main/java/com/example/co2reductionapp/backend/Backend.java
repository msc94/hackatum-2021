package com.example.co2reductionapp.backend;

import android.content.res.Resources;
import android.graphics.BitmapFactory;

import com.example.co2reductionapp.R;
import com.example.co2reductionapp.backend.activities.Activity;
import com.example.co2reductionapp.backend.activities.CommuteActivity;
import com.example.co2reductionapp.backend.activities.ConsumeEnergyActivity;
import com.example.co2reductionapp.backend.activities.ConsumeWaterActivity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Backend {
    private static List<User> users = null;
    private static final Random rand = new Random();

    public static List<User> getUsers(Resources resources) {
        if (users == null) {
            users = createUsers(resources);
        }

        return users;
    }

    private static List<User> createUsers(Resources resources) {
        List<User> users = new ArrayList<>();

        users.add(new User("Alphin Tom", BitmapFactory.decodeResource(resources, R.drawable.alphin)));
        users.add(new User("Nick", BitmapFactory.decodeResource(resources, R.drawable.example_person)));
        users.add(new User("Rohan Menon", BitmapFactory.decodeResource(resources, R.drawable.example_person)));
        users.add(new User("Marcel Schneider", BitmapFactory.decodeResource(resources, R.drawable.example_person)));

        User me = users.get(0);
        for (int i = 1; i < users.size(); i++) {
            me.addFriend(users.get(i));
        }

        List<Activity> activities = createActivities();
        for (int i = 0; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            users.get(i % users.size()).addActivity(activity);
        }

        return users;
    }

    public static Date between(Date startInclusive, Date endExclusive) {
        long startMillis = startInclusive.getTime();
        long endMillis = endExclusive.getTime();

        long randomMillisSinceEpoch = ThreadLocalRandom
                .current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillisSinceEpoch);
    }

    private static List<Activity> createActivities() {
        List<Activity> activities = new ArrayList<>();

        Date startDate = new Date(2021, 11, 01);
        Date endDate = new Date(2021, 11, 20);

        for (int i = 0; i < 10; i++) {
            activities.add(new CommuteActivity().setDatePublished(between(startDate, endDate)));
            activities.add(new ConsumeEnergyActivity().setDatePublished(between(startDate, endDate)));
            activities.add(new ConsumeWaterActivity().setDatePublished(between(startDate, endDate)));
        }

        return activities;
    }
}
