package com.nickmillward.unsplashdemo.ui.presenters;

import android.util.Log;

import com.nickmillward.unsplashdemo.api.UnsplashApi;
import com.nickmillward.unsplashdemo.api.models.PhotoResponse;
import com.nickmillward.unsplashdemo.ui.views.ImageOverviewView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by nmillward on 3/24/17.
 */

public class ImageOverviewPresenter implements Presenter<ImageOverviewView> {

    private ImageOverviewView view;
    private Set<Call<List<PhotoResponse>>> photoCalls;

    @Override
    public void attachView(ImageOverviewView view) {
        this.view = view;
        this.photoCalls = new HashSet<>();
    }

    public void subscribe() {
        view.showImageList();
        updatePhotos();
    }

    public void unsubscribe() {
        // Cancel all in photo updates
        for (Call<List<PhotoResponse>> call : photoCalls) {
            if (call != null && call.isExecuted() && !call.isCanceled()) {
                call.cancel();
            }
        }
        photoCalls.clear();
    }

    public void updatePhotos() {
        view.showLoading();

        final Call<List<PhotoResponse>> photoCall = UnsplashApi.getInstance()
                .getService()
                .getPhotos();

        photoCalls.add(photoCall);
        photoCall.enqueue(new Callback<List<PhotoResponse>>() {
            @Override
            public void onResponse(Call<List<PhotoResponse>> call, Response<List<PhotoResponse>> response) {

                // TODO: Save response to sharedPref

                if (response.isSuccessful()) {
                    List<PhotoResponse> photos = response.body();
                    Log.d("Presenter", "ResponseBody --> " + photos);
                    view.showAddedImages(photos);
                }
            }

            @Override
            public void onFailure(Call<List<PhotoResponse>> call, Throwable t) {
                view.showError();
            }
        });
    }
}
