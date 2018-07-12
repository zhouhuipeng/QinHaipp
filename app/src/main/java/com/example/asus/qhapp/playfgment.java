package com.example.asus.qhapp;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

import java.io.IOException;

/**
 * Created by Asus on 2018/5/24.
 */

public class playfgment extends Fragment {
    private LyricView lyricView;
    private MediaPlayer mediaPlayer;
    private ImageView button;
    private SeekBar seekBar;
    private String mp3Path;
    private int INTERVAL=45;//歌词每行的间隔
    private Button back;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.play, container, false);

        mp3Path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/LyricSync/林俊杰 - 醉赤壁.mp3";

        lyricView = (LyricView) view.findViewById(R.id.mylrc);

        mediaPlayer = new MediaPlayer();
        // this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        try {
            mediaPlayer.setDataSource(mp3Path);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ResetMusic(mp3Path);
        SerchLrc();
        lyricView.SetTextSize();

        button = (ImageView) getActivity().findViewById(R.id.musicplay);
        back=(Button)view.findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();//创建fragment对象
                FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Home_pagerfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();

            }
        });



        seekBar = (SeekBar) getActivity().findViewById(R.id.seekbarmusic);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    lyricView.setOffsetY(220 - lyricView.SelectIndex(progress)
                            * (lyricView.getSIZEWORD() + INTERVAL - 1));

                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (mediaPlayer.isPlaying()) {
                    button.setBackground(null);
                    button.setImageResource(R.mipmap.play);
                    mediaPlayer.pause();
                } else {
                    button.setBackground(null);
                    button.setImageResource(R.mipmap.musicstart);
                    mediaPlayer.start();
                    lyricView.setOffsetY(220 - lyricView.SelectIndex(mediaPlayer.getCurrentPosition())
                            * (lyricView.getSIZEWORD() + INTERVAL - 1));

                }
            }
        });


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                ResetMusic(mp3Path);
                lyricView.SetTextSize();
                lyricView.setOffsetY(200);
                mediaPlayer.start();
            }
        });
        seekBar.setMax(mediaPlayer.getDuration());
        new Thread(new runable()).start();
        return view;
    }

    public void SerchLrc() {
        String lrc = mp3Path;
        lrc = lrc.substring(0, lrc.length() - 4).trim() + ".lrc".trim();
        LyricView.read(lrc);
        lyricView.SetTextSize();
        lyricView.setOffsetY(350);
    }

    public void ResetMusic(String path) {

        mediaPlayer.reset();
        try {

            mediaPlayer.setDataSource(mp3Path);
            mediaPlayer.prepare();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    class runable implements Runnable {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (true) {

                try {
                    Thread.sleep(100);
                    if (mediaPlayer.isPlaying()) {
                        lyricView.setOffsetY(lyricView.getOffsetY() - lyricView.SpeedLrc());
                        lyricView.SelectIndex(mediaPlayer.getCurrentPosition());
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                        mHandler.post(mUpdateResults);
                    }
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    Handler mHandler = new Handler();
    Runnable mUpdateResults = new Runnable() {
        public void run() {
            lyricView.invalidate(); // 更新视图
        }
    };
}
