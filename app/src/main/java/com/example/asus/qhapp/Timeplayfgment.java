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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018/5/23.
 */

public class Timeplayfgment extends Fragment {//历史播放类
    private List<Timeplay> timeplayList=new ArrayList<>();
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.timeplay,container,false);
        Button back=(Button) view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {//返回主界面
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Home_pagerfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();

            }
        });
        listView=(ListView)view.findViewById(R.id.timeplay);
        inittimeplay();

        return view;
    }

    private void inittimeplay() {
        for(int i=0 ;i<20;i++){
            if(i%3==0) {
                Timeplay apple = new Timeplay("青花瓷", "周杰伦", R.mipmap.ok);
                timeplayList.add(apple);
            }
            else{
                Timeplay apple=new Timeplay("青花瓷","周杰伦",R.mipmap.nodownload);
                timeplayList.add(apple);
            }
        }
        TimeplayAdapter adapter=new TimeplayAdapter(getActivity(),R.layout.timeplayitem,timeplayList);
        listView.setAdapter(adapter);
    }
}
