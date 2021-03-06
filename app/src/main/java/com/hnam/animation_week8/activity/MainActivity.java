package com.hnam.animation_week8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;


import com.hnam.animation_week8.R;
import com.hnam.animation_week8.adapter.MealAdapter;
import com.hnam.animation_week8.model.Meal;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.rvMeals)
    RecyclerView rvMeals;

    private MealAdapter mealAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mealAdapter = new MealAdapter();
        rvMeals.setAdapter(mealAdapter);
        mealAdapter.setMealAdapterListener(adapterListener);
        rvMeals.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private MealAdapter.MealAdapterListener adapterListener = new MealAdapter.MealAdapterListener() {

        @Override
        public void onItemClick(ImageView imageView, Meal meal) {
            Intent i  = MealDetailActivity.getIntent(MainActivity.this, meal);
            startActivity(i);
        }

        @Override
        public void onAvatarClick(CircleImageView imageView, String name, String avatar) {
            Intent i  = UserDetailActivity.getIntent(MainActivity.this, name, avatar);
            startActivity(i);
        }

        @Override
        public void onOrderClick(Meal meal) {

        }
    };
}
