package com.example.co2reductionapp.backend.activities;

import android.graphics.Bitmap;

import java.util.Date;

public abstract class Activity {
    private Date datePublished;
    // private String description;
    private Bitmap proof;

    public Date getDatePublished() {
        return datePublished;
    }

    public Activity setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
        return this;
    }

    public Bitmap getProof() {
        return proof;
    }

    public Activity setProof(Bitmap proof) {
        this.proof = proof;
        return this;
    }

    public abstract String getDescription();
    public abstract int calculateDeltaPoints();
}
