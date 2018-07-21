package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/21.
 */

public class SearchResult {
    private int imageID;//搜索音乐是否付费
    private String musicname;//搜索音乐名称
    private String musicsonger;//搜索音乐歌手
    SearchResult(String musicname,String musicsonger,int imageID){
        this.imageID=imageID;
        this.musicname=musicname;
        this.musicsonger=musicsonger;
    };

    public int getImageID() {
        return imageID;
    }

    public String getMusicsonger() {
        return musicsonger;
    }

    public String getMusicname() {
        return musicname;
    }
}
