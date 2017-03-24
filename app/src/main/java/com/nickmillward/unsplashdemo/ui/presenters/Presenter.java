package com.nickmillward.unsplashdemo.ui.presenters;

import com.nickmillward.unsplashdemo.ui.views.View;

/**
 * Created by nmillward on 3/24/17.
 */

public interface Presenter<T extends View> {

    void attachView(T view);

}
