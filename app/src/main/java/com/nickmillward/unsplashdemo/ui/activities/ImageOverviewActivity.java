package com.nickmillward.unsplashdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.api.models.PhotoResponse;
import com.nickmillward.unsplashdemo.ui.adapters.ImageAdapter;
import com.nickmillward.unsplashdemo.ui.presenters.ImageOverviewPresenter;
import com.nickmillward.unsplashdemo.ui.views.ImageOverviewView;

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

        presenter = new ImageOverviewPresenter();
        adapter = new ImageAdapter(this);

        setupRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.subscribe();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.unsubscribe();
    }

    private void setupRecyclerView() {
        gridLayoutManager = new GridLayoutManager(this, COLUMNS);

        // TODO: Handle orientation change -- landscape layout

        rv_main_image_overview.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void showImageList() {
        rv_main_image_overview.setAdapter(adapter);
    }

    @Override
    public void showAddedImages(List<PhotoResponse> images) {
        adapter.onImagesAdded(images);
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
}
