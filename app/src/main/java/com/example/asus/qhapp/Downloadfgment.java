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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018/5/23.
 */

public class Downloadfgment extends Fragment {//下载列表类
    private List<Downloadmusic> downloadmusicList=new ArrayList<>();
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.downloadmusic,container,false);

        Button back=(Button)view.findViewById(R.id.back);
        listView=(ListView)view.findViewById(R.id.downloadmusic);
        initdownloadlist();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//list监听事件
                Downloadmusic downloadmusic=downloadmusicList.get(position);//得到点击的list位置以及信息
            }
        });

        back.setOnClickListener(new View.OnClickListener() {//返回至主界面状态
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

    private void initdownloadlist() {//初始化下载list内容
        for(int i=0;i<20;i++){
            if(i%7==0) {
                Downloadmusic apple = new Downloadmusic("青花瓷", "周杰伦", R.mipmap.pay);
                downloadmusicList.add(apple);
            }
            else{
                Downloadmusic apple=new Downloadmusic("青花瓷","周杰伦",R.mipmap.nodownload);
                downloadmusicList.add(apple);
            }
        }
        DownloadmusicAdapter adapter=new DownloadmusicAdapter(getActivity(),R.layout.downloadmusicitem,downloadmusicList);
        listView.setAdapter(adapter);
    }
}
