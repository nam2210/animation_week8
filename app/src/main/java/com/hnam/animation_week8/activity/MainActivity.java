package com.hnam.animation_week8.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.hnam.animation_week8.R;
import com.hnam.animation_week8.adapter.MealAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

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
        public void onItemClick() {
            Intent i = new Intent(MainActivity.this, MealDetailActivity.class);
            startActivity(i);
        }

        @Override
        public void onAvatarClick() {
            Intent i = new Intent(MainActivity.this, UserDetailActivity.class);
            startActivity(i);
        }

        @Override
        public void onOrderClick() {

        }
    };
}
