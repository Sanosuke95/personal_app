package com.sanosuke.personal_app;

public class HomeModel {

    private String title;
    private int imgid;

    public HomeModel(String title, int imgid) {

        this.title = title;
        this.imgid = imgid;
    }

    public String getTitle() {
        return title;
    }

    public int getImgid() {
        return imgid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }
}
