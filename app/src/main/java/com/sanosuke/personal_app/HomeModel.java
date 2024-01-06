package com.sanosuke.personal_app;

public class HomeModel {

    private final String title;
    private final int imgId;

    public HomeModel(String title, int imgId) {

        this.title = title;
        this.imgId = imgId;
    }

    public String getTitle() {
        return title;
    }

    public int getImgId() {
        return imgId;
    }
    
}
