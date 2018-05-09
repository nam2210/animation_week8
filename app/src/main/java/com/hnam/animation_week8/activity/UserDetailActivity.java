package com.hnam.animation_week8.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hnam.animation_week8.R;
import com.hnam.animation_week8.adapter.ImageAdapter;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class UserDetailActivity extends AppCompatActivity {
    private static final String USERNAME = "username";
    private static final String AVATAR = "avatar";

    public static Intent getIntent(Context context, String username, String avatar) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(USERNAME, username);
        intent.putExtra(AVATAR, avatar);
        return intent;
    }

    @BindView(R.id.rvMeals)
    RecyclerView rvMeals;

    @BindView(R.id.avatar)
    CircleImageView ivAvatar;

    @BindView(R.id.tvUsername)
    TextView tvUsername;

    @BindViews({R.id.tvUsername, R.id.btnFollow, R.id.infoContainer, R.id.rvMeals})
    View[] views;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Transition  t = TransitionInflater.from(this).inflateTransition(R.transition.user_detail_transition);
        getWindow().setSharedElementEnterTransition(t);

        String username = getIntent().getStringExtra(USERNAME);
        String avatar = getIntent().getStringExtra(AVATAR);
        setContentView(R.layout.activity_user_detail);

        ButterKnife.bind(this);
        rvMeals.setAdapter(new ImageAdapter());
        rvMeals.setLayoutManager(new GridLayoutManager(this, 2));

        tvUsername.setText(username);
        Glide.with(this).load(avatar).into(ivAvatar);

        for (View view : views){
            moveUp(view, 600);
        }
    }

    private void moveUp(View view, int duration){
        view.setTranslationY(500);
        view.animate()
            .translationYBy(-500)
            .setDuration(duration)
            .start();
    }


}
