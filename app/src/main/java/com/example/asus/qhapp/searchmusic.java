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

public class searchmusic extends Activity {
    public Button back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchmusic);
        back=(Button) findViewById(R.id.back);
         back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent();
                 intent.setClass(searchmusic.this,mainpager.class);
                 startActivity(intent);
                 overridePendingTransition( R.anim.in_from_right,
                         R.anim.out_to_left);
                 finish();
             }
         });
    }
}
