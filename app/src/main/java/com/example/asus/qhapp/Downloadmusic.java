package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/12.
 */

public class Downloadmusic {
    private int imageID;
    private String musicname;
    private  String musicsonger;

    Downloadmusic(String musicname,String musicsonger,int imageID){
        this.imageID=imageID;
        this.musicname=musicname;
        this.musicsonger=musicsonger;
    }
    public String getMusicsonger() {
        return musicsonger;
    }

    public String getMusicname() {
        return musicname;
    }

    public int getImageID() {
        return imageID;
    }
}
