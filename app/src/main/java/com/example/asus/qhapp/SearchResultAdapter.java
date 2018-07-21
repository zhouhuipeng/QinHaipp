package com.example.asus.qhapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 2018/7/21.
 */

public class SearchResultAdapter extends ArrayAdapter<SearchResult> {//搜索结果的list适配器
    private int resourceID;
    public SearchResultAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<SearchResult> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        SearchResult searchResult=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        TextView searchmusicname=(TextView)view.findViewById(R.id.searchmusicname);
        TextView searchmusicsonger=(TextView)view.findViewById(R.id.searchmusicsonger);
        ImageView ispay=(ImageView)view.findViewById(R.id.ispay);
        searchmusicname.setText(searchResult.getMusicname());
        searchmusicsonger.setText(searchResult.getMusicsonger());
        ispay.setImageResource(searchResult.getImageID());
        return view;
    }
}
