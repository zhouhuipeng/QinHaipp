package com.example.asus.qhapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Asus on 2018/5/23.
 */

public class Fellowmusicfgment extends Fragment {//伴奏音乐类

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fellowmusic,container,false);
        Button back=(Button)view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {//返回主界面
            @Override
            public void onClick(View v) {//返回按钮监听事件
                FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Home_pagerfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();

            }
        });


        return view;
    }
}
