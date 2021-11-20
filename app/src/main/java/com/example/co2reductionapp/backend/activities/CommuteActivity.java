package com.example.co2reductionapp.backend.activities;

public class CommuteActivity extends Activity {
    @Override
    public String getDescription() {
        return "Commuted without car";
    }

    @Override
    public int calculateDeltaPoints() {
        return 0;
    }
}
