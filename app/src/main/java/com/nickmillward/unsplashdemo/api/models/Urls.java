package com.nickmillward.unsplashdemo.api.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by nmillward on 3/25/17.
 */

public class Urls {

    @SerializedName("regular") String image_regular;
    @SerializedName("small") String image_small;

    public String getImage_regular() {
        return image_regular;
    }

    public String getImage_small() {
        return image_small;
    }
}
