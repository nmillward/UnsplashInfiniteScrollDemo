package com.nickmillward.unsplashdemo.ui.presenters;

import com.nickmillward.unsplashdemo.ui.views.ImageOverviewView;

/**
 * Created by nmillward on 3/24/17.
 */

public class ImageOverviewPresenter implements Presenter<ImageOverviewView> {

    private ImageOverviewView view;

    @Override
    public void attachView(ImageOverviewView view) {
        this.view = view;
    }
}
