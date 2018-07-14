package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/14.
 */

public class Timeplay {
    private int imageID;
    private String musicname;
    private String musicsonger;
    Timeplay(String musicname, String musicsonger,int imageID){
        this.musicname=musicname;
        this.musicsonger=musicsonger;
        this.imageID=imageID;
    }

    public String getMusicname() {
        return musicname;
    }

    public String getMusicsonger() {
        return musicsonger;
    }

    public int getImageID() {
        return imageID;
    }
}
