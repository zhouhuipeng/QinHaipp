package com.example.asus.qhapp;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Asus on 2018/7/12.
 */

public class LocalmusicAdapter extends ArrayAdapter<Localmusic> {//本地音乐list适配器
    private int resourceID;
    public LocalmusicAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Localmusic> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Localmusic localmusic=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        TextView musicname=(TextView)view.findViewById(R.id.musicname);
        TextView musicsonger=(TextView)view.findViewById(R.id.musicsonger);
        musicname.setText(localmusic.getMusicname());
        musicsonger.setText(localmusic.getMusicsonger());
        return view;
    }
}
