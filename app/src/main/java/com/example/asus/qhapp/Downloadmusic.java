package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/12.
 */

public class Downloadmusic {
    private String musicname;
    private  String musicsonger;

    Downloadmusic(String musicname,String musicsonger){
        this.musicname=musicname;
        this.musicsonger=musicsonger;
    }
    public String getMusicsonger() {
        return musicsonger;
    }

    public String getMusicname() {
        return musicname;
    }
}
