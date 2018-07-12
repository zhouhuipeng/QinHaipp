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

public class DownloadmusicAdapter extends ArrayAdapter<Downloadmusic> {
    private int resourceID;
    public DownloadmusicAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Downloadmusic> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Downloadmusic downloadmusic=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        TextView downloadmusicname=(TextView)view.findViewById(R.id.downloadmusicname);
        TextView downloadmusicsonger=(TextView)view.findViewById(R.id.downloadmusicsonger);
        downloadmusicname.setText(downloadmusic.getMusicname());
        downloadmusicsonger.setText(downloadmusic.getMusicsonger());
        return view;
    }
}
