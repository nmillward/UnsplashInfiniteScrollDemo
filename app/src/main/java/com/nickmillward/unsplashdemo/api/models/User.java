package com.nickmillward.unsplashdemo.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nmillward on 3/25/17.
 */

public class User {

    @SerializedName("name") String name;
    @SerializedName("location") String location;

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
