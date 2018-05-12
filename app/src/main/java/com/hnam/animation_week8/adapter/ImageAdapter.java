package com.hnam.animation_week8.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.hnam.animation_week8.R;
import com.hnam.animation_week8.utils.DataUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String[] mImages = DataUtils.images();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_image, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).render(mImages[position]);
    }

    @Override
    public int getItemCount() {
        return mImages.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image)
        ImageView iv;

        private Context context;
        public ViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void render(String url) {
            Glide.with(context).load(url).into(iv);
        }

        @OnClick(R.id.image)
        public void onItemClick() {
            // TODO: implement
        }
    }
}