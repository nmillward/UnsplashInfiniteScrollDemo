package com.nickmillward.unsplashdemo.models;

/**
 * Created by nmillward on 3/24/17.
 */

public class Image {

    private String image;
    private String userName;
    private String userLocation;

    public Image(String image, String userName, String userLocation) {
        this.image = image;
        this.userName = userName;
        this.userLocation = userLocation;
    }

    public String getImage() {
        return image;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLocation() {
        return userLocation;
    }
}
