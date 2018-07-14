package com.example.asus.qhapp;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Asus on 2018/5/18.
 */

public class mainpager extends  Activity{//主界面类
    private Button location,download,fellowmusic,time,search;
    private ImageView playpager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpager);

        playpager=(ImageView)findViewById(R.id.playpager);

        FragmentManager manager = getFragmentManager();//创建fragment对象
        FragmentTransaction transaction = manager.beginTransaction();//获取fragment
        //transaction.add(R.id.ly_under,new things());
        transaction.replace(R.id.ly_center, new Home_pagerfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
        transaction.commit();

        playpager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*FragmentManager manager = getFragmentManager();//创建fragment对象
                FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new playfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();*/

                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new playfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });

    }
    // 用来计算返回键的点击间隔时间
   /* private long exitTime = 0;
   @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
       if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_DOWN) {
                 if ((System.currentTimeMillis() - exitTime) > 2000) {
                       //弹出提示，可以有多种方式
                      Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                         exitTime = System.currentTimeMillis();
                    } else {
                        finish();
                  }
                  return true;
             }
        return super.onKeyDown(keyCode, event);
   }*/
}
