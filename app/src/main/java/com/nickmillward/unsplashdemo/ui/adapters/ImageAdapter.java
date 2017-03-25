package com.nickmillward.unsplashdemo.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.ui.models.Image;
import com.nickmillward.unsplashdemo.ui.views.ImageOverviewView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nmillward on 3/24/17.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private ImageOverviewView view;
    private List<Image> images = new ArrayList<>();

    public ImageAdapter(ImageOverviewView view) {
        this.view = view;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_overview, parent, false);
        return new ImageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        Image image = images.get(position);
        //TODO: set image(Glide) and text
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void onImageAdded(Image image) {
        images.add(image);
        notifyItemChanged(images.size() - 1);
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_overview_item_image) ImageView image;
        @BindView(R.id.tv_overview_item_banner_username) TextView userName;
        @BindView(R.id.tv_overview_item_banner_location) TextView userLocation;

        public ImageViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
