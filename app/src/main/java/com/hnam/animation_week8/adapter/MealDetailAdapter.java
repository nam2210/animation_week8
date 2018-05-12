package com.hnam.animation_week8.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hnam.animation_week8.R;
import com.hnam.animation_week8.model.Meal;
import com.hnam.animation_week8.model.Review;
import com.hnam.animation_week8.utils.DataUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class MealDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int HEADER = 0;
    private final int ITEM = 1;
    private List<Review> mReviews;
    private Meal mMeal;

    public MealDetailAdapter(Meal meal) {
        mMeal = meal;
        mReviews = DataUtils.reviews();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case HEADER:
                return new HeaderViewHolder(inflateView(parent, R.layout.item_owner));
            default:
                return new ItemViewHolder(inflateView(parent, R.layout.item_review));
        }
    }

    private View inflateView(ViewGroup parent, int layout) {
        return LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HeaderViewHolder) {
            ((HeaderViewHolder) holder).bind(mMeal);
        } else if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).bind(mReviews.get(position - 1));
        }
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivAvatar)
        CircleImageView ivAvatar;

        private Context context;
        public HeaderViewHolder(View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(Meal meal) {
            Glide.with(context).load(meal.getAvatar()).into(ivAvatar);
        }

        @OnClick(R.id.ivAvatar)
        public void onAvatarClick() {
            //todo
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ivAvatar)
        CircleImageView ivAvatar;

        @BindView(R.id.tvUsername)
        TextView tvUsername;

        @BindView(R.id.tvDate)
        TextView tvDate;

        @BindView(R.id.rating)
        AppCompatRatingBar ratingBar;

        Context context;
        public ItemViewHolder(View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(Review review) {
            Glide.with(context).load(review.getAvatar()).into(ivAvatar);
            tvUsername.setText(review.getUsername());
            tvDate.setText(review.getDate());
            ratingBar.setRating(review.getNumStars());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEADER;
        }
        return ITEM;
    }

    @Override
    public int getItemCount() {
        return mReviews.size() + 1;
    }

    public class UserDetailEvent {
        public final ImageView imageView;
        public final String username;
        public final String avatar;

        public UserDetailEvent(ImageView imageView, String username, String avatar) {
            this.imageView = imageView;
            this.username = username;
            this.avatar = avatar;
        }
    }
}