package com.nickmillward.unsplashdemo.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nmillward on 3/25/17.
 */

public class UnsplashApi {

    private static final String BASE_URL = "https://api.unsplash.com";
    private static final String AUTH_ID = "Authorization: Client-ID 7722d16f0aa594e42744971bc1453894529e924055f3cd2bfebdba439e6e0017";
    private static UnsplashApi instance;
    private UnsplashService service;

    private UnsplashApi() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(UnsplashService.class);
    }

    public static UnsplashApi getInstance() {
        if (instance == null) {
            instance = new UnsplashApi();
        }

        return instance;
    }

    public UnsplashService getService() {
        return service;
    }

    private OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();
            Request.Builder builder = originalRequest.newBuilder().header("Authorization", AUTH_ID);
            Request newRequest = builder.build();
            return chain.proceed(newRequest);
        }
    }).build();
}
