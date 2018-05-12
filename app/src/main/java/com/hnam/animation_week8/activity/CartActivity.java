package com.hnam.animation_week8.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

import com.hnam.animation_week8.R;
import com.hnam.animation_week8.adapter.ImageAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CartActivity extends AppCompatActivity {

    @BindView(R.id.activity_cart)
    ViewGroup parent;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.rvMeals)
    RecyclerView rvMeals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        overridePendingTransition(0, 0);
        ButterKnife.bind(this);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvMeals.setAdapter(new ImageAdapter());
        rvMeals.setLayoutManager(new GridLayoutManager(this, 2));
        parent.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        enterReveal();
                        parent.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onBackPressed() {
        exitReveal();
    }

    public void enterReveal() {
        int cx = (int) (fab.getX() + fab.getMeasuredWidth() / 2);
        int cy = (int) (fab.getY() + fab.getMeasuredHeight() / 2);
        int finalRadius = Math.max(parent.getWidth(), parent.getHeight());
        ViewAnimationUtils.createCircularReveal(parent, cx, cy, 0, finalRadius).start();
    }

    public void exitReveal() {
        int cx = (int) (fab.getX() + fab.getMeasuredWidth() / 2);
        int cy = (int) (fab.getY() + fab.getMeasuredHeight() / 2);
        int startRadius = Math.max(parent.getWidth(), parent.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(parent, cx, cy,
                startRadius, fab.getMeasuredWidth() / 2);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                parent.setVisibility(View.INVISIBLE);
                finish();
                overridePendingTransition(0, 0);
            }
        });
        animator.start();
    }
}
