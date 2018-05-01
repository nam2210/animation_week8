package com.hnam.animation_week8.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rvMeals.setAdapter(new MealAdapter());
        rvMeals.setLayoutManager(new GridLayoutManager(this, 2));
    }
}
