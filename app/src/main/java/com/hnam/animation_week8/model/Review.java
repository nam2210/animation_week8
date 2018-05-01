package com.hnam.animation_week8.model;

import org.parceler.Parcel;

import java.io.Serializable;


@Parcel
public class Review {
    String username;
    String avatar;
    String content;
    String date;
    int numStars;

    public Review(){}

    public Review(String username, String avatar, String content, String date, int numStars) {
        this.username = username;
        this.avatar = avatar;
        this.content = content;
        this.date = date;
        this.numStars = numStars;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public int getNumStars() {
        return numStars;
    }
}
