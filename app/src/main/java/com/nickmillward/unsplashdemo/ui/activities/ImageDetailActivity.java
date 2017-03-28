package com.nickmillward.unsplashdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.ui.views.ImageDetailView;

public class ImageDetailActivity extends AppCompatActivity implements ImageDetailView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public void navigateToOverviewScreen() {

    }
}
