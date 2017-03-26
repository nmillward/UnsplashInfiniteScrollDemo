package com.nickmillward.unsplashdemo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nmillward on 3/25/17.
 */

public class UnsplashApi {

    private static final String BASE_URL = "https://api.unsplash.com";
    private UnsplashService service;

    public UnsplashApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(UnsplashService.class);
    }

    public UnsplashService getService() {
        return service;
    }
}