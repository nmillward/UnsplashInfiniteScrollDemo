package com.nickmillward.unsplashdemo.ui.views;

import com.nickmillward.unsplashdemo.models.Image;

/**
 * Created by nmillward on 3/24/17.
 */

public interface ImageOverviewView extends View {
    void showImageList();
    void showAddedImages(Image image);
    void showLoading();
    void hideLoading();
    void showError();
}
