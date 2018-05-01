package com.hnam.animation_week8.utils;

import com.hnam.animation_week8.model.Meal;
import com.hnam.animation_week8.model.Review;

import java.util.ArrayList;
import java.util.List;



public class DataUtils {

    public static String[] images() {
        return new String[]{
                "http://images.media-allrecipes.com/images/50717.jpg",
                "https://i.ytimg.com/vi/u1w7zqbBiXM/maxresdefault.jpg",
                "http://app.cookingmatters.org/sites/default/files/sos-img/Ratatouille.jpg",
                "http://www.seriouseats.com/recipes/assets_c/2013/09/20130922-266596-sunday-brunch-ratatouille-fried-eggs-thumb-625xauto-352893.jpg",
                "https://encrypted-tbn1.gstatic.com/mImages?q=tbn:ANd9GcSaSi9cqP-Ri9rCsLQQtOTkcQ9RVhJ-B8E--nehLWcR7MYZMfrR",
                "https://encrypted-tbn3.gstatic.com/mImages?q=tbn:ANd9GcRy3SItnS5jMVbsDWQix5sbvh25mbdJ6QjW8l-eNOHSPP1QqOtP",
                "https://encrypted-tbn3.gstatic.com/mImages?q=tbn:ANd9GcTf4tLgsCSTKFW_M8okYxh7YbDzp1cbTBx6h5N7FpQe5JPfLY0saA",
                "https://encrypted-tbn1.gstatic.com/mImages?q=tbn:ANd9GcS4povIEXYYbENYsG-A-7mRQ5GYJlR6wmQwPHCThQHEjYrLh1caRg",
                "https://encrypted-tbn3.gstatic.com/mImages?q=tbn:ANd9GcTVC2146zTHrTSqmuRqvQjT18a58PoMIqdOUc8zI9Nf_4oJzDBU"
        };
    }


    public static List<Meal> meals() {
        List<Meal> meals = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            meals.add(new Meal("Title " + i,
                    images()[i % images().length],
                    "User " + i,
                    images()[i % images().length],
                    i % 5, i * 10, i * 100));
        }
        return meals;
    }

    public static List<Review> reviews() {
        List<Review> reviews = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            reviews.add(new Review("User " + i,
                    images()[i % images().length],
                    "This is a content " + i,
                    "02/05/2018",
                    i % 5));
        }
        return reviews;
    }
}
