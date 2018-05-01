package com.hnam.animation_week8.model;

import org.parceler.Parcel;

import java.io.Serializable;


@Parcel
public class Meal {
    String title;
    String image;
    String username;
    String avatar;
    float numStars;
    int numLikes;
    int numOrders;

    public Meal(){}


    public Meal(String title, String image, String username, String avatar,
                float numStars, int numLikes, int numOrders) {
        this.title = title;
        this.image = image;
        this.username = username;
        this.avatar = avatar;
        this.numStars = numStars;
        this.numLikes = numLikes;
        this.numOrders = numOrders;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public float getNumStars() {
        return numStars;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public int getNumOrders() {
        return numOrders;
    }
}
