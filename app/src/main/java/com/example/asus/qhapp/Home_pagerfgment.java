package com.example.asus.qhapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Asus on 2018/7/8.
 */

public class Home_pagerfgment extends Fragment {//Fragment类进行设置为以及界面的主界面
    @Nullable
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mInfo;
    private String APPID="1106998736";

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.mainfirstpager,container,false);
        Button location=(Button)view.findViewById(R.id.location);//本地音乐
        Button download=(Button)view.findViewById(R.id.download);//下载音乐
        Button fellow=(Button)view.findViewById(R.id.fellowmusic);//伴奏音乐
        Button timeplay=(Button)view.findViewById(R.id.timeplay);//历史播放
        Button search=(Button)view.findViewById(R.id.search);//查找音乐

        mTencent = Tencent.createInstance(APPID,getActivity().getApplication());

        LinearLayout l =  (LinearLayout) view.findViewById(R.id.user);
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

        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIUiListener = new BaseUiListener();
                mTencent.login(getActivity(),"all", mIUiListener);
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

        search.setOnClickListener(new View.OnClickListener() {//将mainpager中的ly_center加载搜索界面
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

    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(getActivity().getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
            Log.e("tag", "response:" + response);
            JSONObject jo = (JSONObject) response;

            try {
                String openID = jo.getString("openid");
                String accessToken = jo.getString("access_token");
                String expires = jo.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken, expires);
                QQToken qqToken = mTencent.getQQToken();
                mInfo = new UserInfo(getActivity().getApplicationContext(), qqToken);
                mInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e("BaseUiListener", "成功"+response.toString());
                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e("BaseUiListener", "失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e("BaseUiListener", "取消");
                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(getActivity().getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(getActivity().getApplicationContext(), "登录取消", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("TAG", "-->onActivityResult " + requestCode  + " resultCode=" + resultCode);
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
