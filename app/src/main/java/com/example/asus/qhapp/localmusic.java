package com.example.asus.qhapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Asus on 2018/5/23.
 */

public class localmusic extends Activity {//本地音乐类
    private Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localmusic);
        back=(Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {//返回主界面
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.setClass(localmusic.this,mainpager.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
