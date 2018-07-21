package com.example.asus.qhapp;

/**
 * Created by Asus on 2018/7/12.
 */

public class Downloadmusic {//下载list单元内部类
    private int imageID;//是否已经下载
    private String musicname;//音乐名称
    private  String musicsonger;//歌手

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
