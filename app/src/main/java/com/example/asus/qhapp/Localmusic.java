package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/12.
 */

public class Localmusic {
    private String musicname;//本地音乐名称
    private String musicsonger;//本地音乐歌手
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
