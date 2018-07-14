package com.example.asus.qhapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Asus on 2018/7/8.
 */

public class Home_pagerfgment extends Fragment {//Fragment类进行设置为以及界面的主界面
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.mainfirstpager,container,false);
        Button location=(Button)view.findViewById(R.id.location);//本地音乐
        Button download=(Button)view.findViewById(R.id.download);//下载音乐
        Button fellow=(Button)view.findViewById(R.id.fellowmusic);//伴奏音乐
        Button timeplay=(Button)view.findViewById(R.id.timeplay);//历史播放
        Button search=(Button)view.findViewById(R.id.search);//查找音乐

        location.setOnClickListener(new View.OnClickListener() {//向mainpager中的ly_center加载本地音乐界面
            @Override
            public void onClick(View v) {
               /* FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Localmusicfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();*/

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new Localmusicfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();

            }
        });

        download.setOnClickListener(new View.OnClickListener() {//将mainpager中的ly_center加载下载界面；
            @Override
            public void onClick(View v) {
               /* FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Downloadfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();*/

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new Downloadfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();

            }
        });

        fellow.setOnClickListener(new View.OnClickListener() {//将mainpager中的ly_center加载伴随下载界面
            @Override
            public void onClick(View v) {
                /*FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Fellowmusicfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();*/

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new Fellowmusicfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });

        timeplay.setOnClickListener(new View.OnClickListener() {//将mainpager中的ly_center加载历史播放界面
            @Override
            public void onClick(View v) {
               /* FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Timeplayfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();*/

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new Timeplayfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Searchmusicfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();*/
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new Searchmusicfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });


        return view;
    }


}
