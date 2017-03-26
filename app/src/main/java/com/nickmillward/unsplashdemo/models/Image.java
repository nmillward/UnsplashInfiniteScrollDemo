package com.nickmillward.unsplashdemo.models;

/**
 * Created by nmillward on 3/24/17.
 */

public class Image {

    private String regular;
    private String name;
    private String location;

    public Image(String image, String userName, String userLocation) {
        this.regular = image;
        this.name = userName;
        this.location = userLocation;
    }

    public String getRegular() {
        return regular;
    }

    public String getUserName() {
        return name;
    }

    public String getUserLocation() {
        return location;
    }
}
