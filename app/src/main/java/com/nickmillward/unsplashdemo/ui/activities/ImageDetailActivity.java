package com.nickmillward.unsplashdemo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nickmillward.unsplashdemo.R;
import com.nickmillward.unsplashdemo.ui.views.ImageDetailView;

public class ImageDetailActivity extends AppCompatActivity implements ImageDetailView {

    public static final String KEY_USER_NAME = "userName";
    public static final String KEY_USER_LOCATION = "userLocation";
    public static final String KEY_PHOTO_URL = "photoUrl";

    private String userName;
    private String userLocation;
    private String photoUrl_regular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initIntentExtras();

    }

    private void initIntentExtras() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString(KEY_USER_NAME);
            userLocation = extras.getString(KEY_USER_LOCATION);
            photoUrl_regular = extras.getString(KEY_PHOTO_URL);
        }
    }

    @Override
    public void navigateToOverviewScreen() {

    }
}
