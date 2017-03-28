package com.nickmillward.unsplashdemo.api;

import com.nickmillward.unsplashdemo.api.models.PhotoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nmillward on 3/25/17.
 */

public interface UnsplashService {

    @GET("photos/?client_id=7722d16f0aa594e42744971bc1453894529e924055f3cd2bfebdba439e6e0017")
    Call<List<PhotoResponse>> getPhotos();

}
