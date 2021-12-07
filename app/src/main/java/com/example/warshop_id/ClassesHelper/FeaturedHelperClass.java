package com.example.warshop_id.ClassesHelper;

public class FeaturedHelperClass {

    int image;
    String title, address;

    public FeaturedHelperClass(int image, String title, String address) {
        this.image = image;
        this.title = title;
        this.address = address;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }
}
