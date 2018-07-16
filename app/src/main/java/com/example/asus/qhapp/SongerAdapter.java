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
 * Created by Asus on 2018/7/16.
 */

public class SongerAdapter extends ArrayAdapter<Songer> {
    private int resourceID;
    public SongerAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Songer> objects) {
        super(context, resource, objects);
        resourceID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Songer songer=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView songerimage=(ImageView)view.findViewById(R.id.songerimage);
        TextView songername=(TextView)view.findViewById(R.id.songername);
        songerimage.setImageBitmap(songer.getBitmap());
        songername.setText(songer.getSongername());
        return view;
    }
}
