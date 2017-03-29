package com.nickmillward.unsplashdemo.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.api.models.PhotoResponse;
import com.nickmillward.unsplashdemo.ui.adapters.ImageAdapter;
import com.nickmillward.unsplashdemo.ui.presenters.ImageOverviewPresenter;
import com.nickmillward.unsplashdemo.ui.views.ImageOverviewView;
import com.nickmillward.unsplashdemo.utils.ItemClickListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageOverviewActivity extends AppCompatActivity implements ImageOverviewView {

    public static final String TAG = ImageOverviewActivity.class.getSimpleName();
    private static final int COLUMNS = 2;

    @BindView(R.id.rv_main_image_overview) RecyclerView rv_main_image_overview;

    private ImageOverviewPresenter presenter;
    private GridLayoutManager gridLayoutManager;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_overview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        setupAdapter();
        setupRecyclerView();
        setupPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void setupAdapter() {
        adapter = new ImageAdapter(this, new ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.cardviewItemClicked(view, position);
            }
        });
    }

    private void setupPresenter() {
        presenter = new ImageOverviewPresenter();
        presenter.attachView(this);
        presenter.subscribe();
    }

    private void setupRecyclerView() {
        gridLayoutManager = new GridLayoutManager(this, COLUMNS);

        // TODO: Handle orientation change -- landscape layout

        rv_main_image_overview.hasFixedSize();
        rv_main_image_overview.setLayoutManager(gridLayoutManager);
        Log.d(TAG, "--> set layout manager");
    }

    @Override
    public void showImageList() {
        rv_main_image_overview.setAdapter(adapter);
        Log.d(TAG, "--> show image list");
    }

    @Override
    public void showAddedImages(List<PhotoResponse> images) {
        adapter.addPhotos(images);
        Log.d(TAG, "--> show added images");
    }

    @Override
    public void showLoading() {
        Log.d(TAG, "--> Loading...");
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {
        Log.d(TAG, "--> Error");
    }

    @Override
    public void navigateToDetailScreen(View view, int position) {
        Intent intent = new Intent(this, ImageDetailActivity.class);
        List<PhotoResponse> photoList = adapter.getPhotos();
        intent.putExtra(ImageDetailActivity.KEY_USER_NAME, photoList.get(position).getUser().getName());
        intent.putExtra(ImageDetailActivity.KEY_USER_LOCATION, photoList.get(position).getUser().getLocation());
        intent.putExtra(ImageDetailActivity.KEY_PHOTO_URL, photoList.get(position).getUrls().getImage_regular());
        Log.d(TAG, "send username details --> " + photoList.get(position).getUser().getName());
        Log.d(TAG, "send url details --> " + photoList.get(position).getUrls().getImage_regular());
        startActivity(intent);
//        overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
    }


}
