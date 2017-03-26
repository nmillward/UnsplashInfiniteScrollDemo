package com.nickmillward.unsplashdemo.api;

import com.nickmillward.unsplashdemo.api.models.PhotoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nmillward on 3/25/17.
 */

public interface UnsplashService {

    @GET("photos")
    Call<List<PhotoResponse>> getPhotos();

}
