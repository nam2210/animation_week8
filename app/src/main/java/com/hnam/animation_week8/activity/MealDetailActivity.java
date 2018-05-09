package com.hnam.animation_week8.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.hnam.animation_week8.R;
import com.hnam.animation_week8.adapter.MealDetailAdapter;
import com.hnam.animation_week8.model.Meal;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MealDetailActivity extends AppCompatActivity {
    private static final String MEAL = "meal";
    private Handler mHandler;

    @BindView(R.id.rvContent)
    RecyclerView rvContent;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.cover)
    ImageView ivCover;

    public static Intent getIntent(Context context, Meal meal) {
        Intent intent = new Intent(context, MealDetailActivity.class);
        intent.putExtra(MEAL, Parcels.wrap(meal));
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Meal meal = (Meal) Parcels.unwrap(getIntent().getParcelableExtra(MEAL));
        setContentView(R.layout.activity_meal_detail);
        ButterKnife.bind(this);
        rvContent.setAdapter(new MealDetailAdapter(meal));
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        setUpToolbar();
        setUpFab();

        Glide.with(this).load(meal.getImage()).into(ivCover);

    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void setUpFab() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                fab.show();
            }
        }, 500);
    }


    @Override
    public void onBackPressed() {
        fab.animate().alpha(0)
                .scaleX(0)
                .scaleY(0)
                .setDuration(300)
                .setInterpolator(new AccelerateInterpolator())
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        MealDetailActivity.super.onBackPressed();
                    }
                }).start();
    }
}
