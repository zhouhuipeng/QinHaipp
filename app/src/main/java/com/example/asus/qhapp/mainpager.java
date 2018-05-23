package com.example.asus.qhapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asus on 2018/5/18.
 */

public class mainpager extends  Activity{//主界面类
    private Button location,download,fellowmusic,time;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpager);
        location=(Button)findViewById(R.id.location);
        download=(Button)findViewById(R.id.download);
        fellowmusic=(Button)findViewById(R.id.fellowmusic);
        time=(Button)findViewById(R.id.time);

        location.setOnClickListener(new View.OnClickListener() {//点击进入本地音乐界面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(mainpager.this,localmusic.class);
                startActivity(intent);
                finish();
            }
        });

        download.setOnClickListener(new View.OnClickListener() {//点击进入下载列表界面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(mainpager.this,download.class);
                startActivity(intent);
                finish();
            }
        });

        fellowmusic.setOnClickListener(new View.OnClickListener() {//点击进入伴奏音乐界面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(mainpager.this,fellowmusic.class);
                startActivity(intent);
                finish();
            }
        });

        time.setOnClickListener(new View.OnClickListener() {//点击进入历史播放界面
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(mainpager.this,timeplay.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
