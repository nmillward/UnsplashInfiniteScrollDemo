package com.nickmillward.unsplashdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.ui.models.Image;
import com.nickmillward.unsplashdemo.ui.views.ImageOverviewView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageOverviewActivity extends AppCompatActivity implements ImageOverviewView {

    private static final int COLUMNS = 2;

    @BindView(R.id.rv_main_image_overview) RecyclerView rv_main_image_overview;

    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_overview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        setupRecyclerView();

    }

    private void setupRecyclerView() {
        gridLayoutManager = new GridLayoutManager(this, COLUMNS);

        // TODO: Handle orientation change -- landscape layout

        rv_main_image_overview.setLayoutManager(gridLayoutManager);
    }

    @Override
    public void showImageList() {

    }

    @Override
    public void showAddedImages(Image image) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }
}
