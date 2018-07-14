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

import java.sql.Time;
import java.util.List;

/**
 * Created by Asus on 2018/7/14.
 */

public class TimeplayAdapter extends ArrayAdapter<Timeplay> {
    private int resourceID;
    public TimeplayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Timeplay> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Timeplay timeplay=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        TextView musicname=(TextView)view.findViewById(R.id.timeplaymusicname);
        TextView musicsonger=(TextView)view.findViewById(R.id.timeplaymusicsonger);
        ImageView isdownload=(ImageView)view.findViewById(R.id.isdownload);
        musicname.setText(timeplay.getMusicname());
        musicsonger.setText(timeplay.getMusicsonger());
        isdownload.setImageResource(timeplay.getImageID());
        return view;
    }
}
