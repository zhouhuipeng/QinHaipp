package com.example.asus.qhapp;

import android.graphics.Bitmap;

/**
 * Created by Asus on 2018/7/16.
 */

public class Songer {
    private Bitmap bitmap;
    private String songername;
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
