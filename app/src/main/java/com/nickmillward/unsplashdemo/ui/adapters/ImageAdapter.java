package com.nickmillward.unsplashdemo.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.api.models.PhotoResponse;
import com.nickmillward.unsplashdemo.models.Image;
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
    private List<PhotoResponse> photos = new ArrayList<>();

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
//        Image image = images.get(position);
        //TODO: set image(Glide) and text

        PhotoResponse photo = photos.get(position);
        holder.userName.setText(photo.getUser().getName());
        holder.userLocation.setText(photo.getUser().getLocation());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public void onImagesAdded(List<PhotoResponse> photos) {
//        images.add(photos);
//        notifyItemChanged(images.size() - 1);
        this.photos = photos;
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
