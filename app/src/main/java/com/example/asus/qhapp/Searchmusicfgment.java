package com.example.asus.qhapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 2018/5/23.
 */

public class Searchmusicfgment extends Fragment implements View.OnClickListener {
    private AutoCompleteTextView searchinputtext;
    private ArrayAdapter<String> oldsearchadapter;
    private List<SearchResult> searchResultList=new ArrayList<>();
    ListView searchresult;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.searchmusic, container, false);
        Button back = (Button) view.findViewById(R.id.back);
        Button gosearch = (Button) view.findViewById(R.id.gosearch);
        TextView songersort = (TextView) view.findViewById(R.id.textView);
        searchinputtext = (AutoCompleteTextView) view.findViewById(R.id.searinputtext);
        searchresult=(ListView)view.findViewById(R.id.searchresult);
        initsearchResult();

        searchresult.setOnItemClickListener(new AdapterView.OnItemClickListener() {//list监听事件
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        String[] arr = new String[1000];
        oldsearchadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);
        searchinputtext.setAdapter(oldsearchadapter);
        initAutoComplete("history", searchinputtext);


        gosearch.setOnClickListener(this);
        searchinputtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr = new String[1000];
                oldsearchadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, arr);
                searchinputtext.setAdapter(oldsearchadapter);
                initAutoComplete("history", searchinputtext);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//返回按钮监听事件
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Home_pagerfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();
            }
        });

        songersort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//歌手分类textview监听事件
                FragmentTransaction ft2 = getFragmentManager().beginTransaction();
                ft2.replace(R.id.ly_center, new Songersortfgment());
                ft2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });

        return view;
    }

    private void initsearchResult() {//搜索结果list初始化函数
        for(int i=0;i<20;i++){
            if(i%5==0){
                SearchResult apple=new SearchResult("青花瓷","周杰伦",R.mipmap.pay);
                searchResultList.add(apple);
            }
            else {
                SearchResult apple =new SearchResult("离人愁","李袁杰",R.mipmap.nodownload);
                searchResultList.add(apple);
            }
        }
        SearchResultAdapter adapter=new SearchResultAdapter(getContext(),R.layout.searchresultitem,searchResultList);
        searchresult.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {//搜索按钮的监听事件触发事件
        saveHistory("history", searchinputtext);
    }

    private void initAutoComplete(String field, AutoCompleteTextView auto) {//用SharedPreferences永久存储搜索记录

        SharedPreferences sp = getActivity().getSharedPreferences("network_url", 0);
        String longhistory = sp.getString("history", "");
        String[] hisArrays = longhistory.split(",");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, hisArrays);
        //只保留最近的50条的记录
        if (hisArrays.length > 50) {
            String[] newArrays = new String[50];
            System.arraycopy(hisArrays, 0, newArrays, 0, 50);
            adapter = new ArrayAdapter<String>(getActivity(),
                    android.R.layout.simple_dropdown_item_1line, newArrays);
        }
        auto.setAdapter(adapter);
        auto.setDropDownHeight(1000);
        auto.setThreshold(1);
        auto.setCompletionHint("最近的搜索记录");
        auto.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                AutoCompleteTextView view = (AutoCompleteTextView) v;
                if (hasFocus) {
                    view.showDropDown();
                }
            }
        });
    }


    private void saveHistory(String field, AutoCompleteTextView auto) {//点击搜索按钮保存此次搜索的内容
        String text = auto.getText().toString();
        SharedPreferences sp = getActivity().getSharedPreferences("network_url", 0);
        String longhistory = sp.getString(field, "nothing");
        if (!longhistory.contains(text + ",")) {
            StringBuilder sb = new StringBuilder(longhistory);
            sb.insert(0, text + ",");
            sp.edit().putString("history", sb.toString()).commit();

        }
    }
}

