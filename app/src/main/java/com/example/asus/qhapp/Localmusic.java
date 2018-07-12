package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/12.
 */

public class Localmusic {
    private String musicname;
    private String musicsonger;
    Localmusic(String musicname,String musicsonger){
        this.musicname=musicname;
        this.musicsonger=musicsonger;
    }

    public String getMusicname() {
        return musicname;
    }

    public String getMusicsonger() {
        return musicsonger;
    }
}
