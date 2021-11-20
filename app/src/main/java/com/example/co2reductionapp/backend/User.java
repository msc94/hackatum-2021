package com.example.co2reductionapp.backend;

import android.graphics.Bitmap;

import com.example.co2reductionapp.backend.activities.Activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {
    private final String name;
    private final Bitmap profilePicture;

    /**
     * Additional data:
     * - birthday
     * - ...
     **/

    private final List<Activity> activities = new ArrayList<>();
    private final List<User> friends = new ArrayList<>();

    private int greenGems = 170;
    private int blueGems = 150;

    public User(String name, Bitmap profilePicture) {
        this.name = name;
        this.profilePicture = profilePicture;
    }

    public int getGreenGems() {
        return greenGems;
    }

    public void setGreenGems(int greenGems) {
        this.greenGems = greenGems;
    }

    public int getBlueGems() {
        return blueGems;
    }

    public void setBlueGems(int blueGems) {
        this.blueGems = blueGems;
    }

    public String getName() {
        return name;
    }

    public Bitmap getProfilePicture() {
        return profilePicture;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Activity> getActivities() {
        return Collections.unmodifiableList(activities);
    }

    public void addFriend(User friend) {
        friends.add(friend);
    }

    public List<User> getFriends() {
        return Collections.unmodifiableList(friends);
    }
}
