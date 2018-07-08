package com.example.asus.qhapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asus on 2018/5/18.
 */

public class mainpager extends  Activity{//主界面类
    private Button location,download,fellowmusic,time,search;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpager);
        FragmentManager manager = getFragmentManager();//创建fragment对象
        FragmentTransaction transaction = manager.beginTransaction();//获取fragment
        //transaction.add(R.id.ly_under,new things());
        transaction.replace(R.id.ly_center, new Home_pagerfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
        transaction.commit();
    }
}
