package com.example.asus.qhapp;

import android.graphics.Bitmap;

/**
 * Created by Asus on 2018/7/16.
 */

public class Songer {
    private Bitmap bitmap;//通过okhttp3请求网页得到的图片，位图，歌手头像
    private String songername;//歌手名称
    Songer(Bitmap bitmap,String songername){
        this.bitmap=bitmap;
        this.songername=songername;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public String getSongername() {
        return songername;
    }
}
