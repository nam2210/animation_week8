package com.hnam.animation_week8.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hnam.animation_week8.R;
import com.hnam.animation_week8.model.Meal;
import com.hnam.animation_week8.utils.DataUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class MealAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Meal> mMeals = DataUtils.meals();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meal, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).render(mMeals.get(position));
    }

    @Override
    public int getItemCount() {
        return mMeals.size();
    }

    private MealAdapterListener mListener;

    public void setMealAdapterListener(MealAdapterListener listener){
        this.mListener = listener;
    }

    public interface MealAdapterListener{
        void onItemClick();
        void onAvatarClick();
        void onOrderClick();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.container)
        CardView container;

        @BindView(R.id.ivMeal)
        ImageView imageView;

        @BindView(R.id.ivAvatar)
        CircleImageView avatar;

        @BindView(R.id.tvTitle)
        TextView tvTitle;

        @BindView(R.id.tvOrder)
        TextView tvOrder;

        @BindView(R.id.ratingBar)
        AppCompatRatingBar ratingBar;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            this.context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }
        private Meal meal;
        public void render(Meal meal){
            this.meal = meal;
            Glide.with(context).load(meal.getImage()).into(imageView);
            Glide.with(context).load(meal.getAvatar()).into(avatar);
            tvTitle.setText(meal.getTitle());
            ratingBar.setRating(meal.getNumStars());
        }


        @OnClick(R.id.container)
        public void onItemClick() {

        }

        @OnClick(R.id.ivAvatar)
        public void onAvatarClick() {

        }

        @OnClick(R.id.tvOrder)
        public void onOrderClick() {

        }
    }


    public class MealDetailEvent {
        public final ImageView imageView;
        public final Meal meal;

        public MealDetailEvent(ImageView imageView, Meal meal) {
            this.imageView = imageView;
            this.meal = meal;
        }
    }

    public class OrderEvent {
        public final String image;
        public final ImageView imageView;

        public OrderEvent(String image, ImageView imageView) {
            this.image = image;
            this.imageView = imageView;
        }
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
