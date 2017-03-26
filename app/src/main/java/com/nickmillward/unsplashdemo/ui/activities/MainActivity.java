package com.nickmillward.unsplashdemo.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startApp();

    }

    private void startApp() {
        startActivity(new Intent(this, ImageOverviewActivity.class));
    }
}
