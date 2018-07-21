package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/14.
 */

public class Timeplay {
    private int imageID;//历史播放音乐是否付费
    private String musicname;//音乐名称
    private String musicsonger;//歌手名称
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
