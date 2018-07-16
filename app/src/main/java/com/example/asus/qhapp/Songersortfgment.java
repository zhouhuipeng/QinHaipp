package com.example.asus.qhapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Asus on 2018/7/15.
 */

public class Songersortfgment extends Fragment {
    private List<Songer> songerlist=new ArrayList<>();
    public OkHttpClient okHttpClient;
    ListView listview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.songersort,container,false);
        Button back=(Button) view.findViewById(R.id.back);
        final TextView locationall=(TextView)view.findViewById(R.id.locationall);
        final TextView locationneidi=(TextView)view.findViewById(R.id.locationneidi);
        final TextView locationgangtai=(TextView)view.findViewById(R.id.locationgangtai);
        final TextView locationomei=(TextView)view.findViewById(R.id.locationomei);
        final TextView locationjapan=(TextView)view.findViewById(R.id.locationjapan);
        final TextView locationhanguo=(TextView)view.findViewById(R.id.locationhanguo);
        final TextView sexall=(TextView)view.findViewById(R.id.sexall);
        final TextView sexman=(TextView)view.findViewById(R.id.sexman);
        final TextView sexwomen=(TextView)view.findViewById(R.id.sexwomen);
        final TextView sexzuhe=(TextView)view.findViewById(R.id.sexzuhe);
        final TextView styleall=(TextView)view.findViewById(R.id.styleall);
        final TextView styleliuxing=(TextView)view.findViewById(R.id.styleliuxing);
        final TextView stylexiha=(TextView)view.findViewById(R.id.stylexiha);
        final TextView styleyaogun=(TextView)view.findViewById(R.id.styleyaogun);
        final TextView stylejueshi=(TextView)view.findViewById(R.id.stylejueshi);
        final TextView styledianzi=(TextView)view.findViewById(R.id.styledianzi);
        final TextView whichlocationselect=(TextView)view.findViewById(R.id.whichlocationselect);
        final TextView whichsexselect=(TextView)view.findViewById(R.id.whichsexselect);
        final TextView whichstyleselect=(TextView)view.findViewById(R.id.whichstyleselect);
        listview=(ListView)view.findViewById(R.id.songerlistview);
        initsongerlist();



        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        locationall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationall.setTextColor(Color.BLACK);
                locationgangtai.setTextColor(Color.GRAY);
                locationhanguo.setTextColor(Color.GRAY);
                locationjapan.setTextColor(Color.GRAY);
                locationneidi.setTextColor(Color.GRAY);
                locationomei.setTextColor(Color.GRAY);
                whichlocationselect.setText(locationall.getText());
            }
        });
        locationgangtai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationall.setTextColor(Color.GRAY);
                locationgangtai.setTextColor(Color.BLACK);
                locationhanguo.setTextColor(Color.GRAY);
                locationjapan.setTextColor(Color.GRAY);
                locationneidi.setTextColor(Color.GRAY);
                locationomei.setTextColor(Color.GRAY);
                whichlocationselect.setText(locationgangtai.getText());
            }
        });
        locationhanguo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationall.setTextColor(Color.GRAY);
                locationgangtai.setTextColor(Color.GRAY);
                locationhanguo.setTextColor(Color.BLACK);
                locationjapan.setTextColor(Color.GRAY);
                locationneidi.setTextColor(Color.GRAY);
                locationomei.setTextColor(Color.GRAY);
                whichlocationselect.setText(locationhanguo.getText());
            }
        });
        locationjapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationall.setTextColor(Color.GRAY);
                locationgangtai.setTextColor(Color.GRAY);
                locationhanguo.setTextColor(Color.GRAY);
                locationjapan.setTextColor(Color.BLACK);
                locationneidi.setTextColor(Color.GRAY);
                locationomei.setTextColor(Color.GRAY);
                whichlocationselect.setText(locationjapan.getText());
            }
        });
        locationneidi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationall.setTextColor(Color.GRAY);
                locationgangtai.setTextColor(Color.GRAY);
                locationhanguo.setTextColor(Color.GRAY);
                locationjapan.setTextColor(Color.GRAY);
                locationneidi.setTextColor(Color.BLACK);
                locationomei.setTextColor(Color.GRAY);
                whichlocationselect.setText(locationneidi.getText());
            }
        });
        locationomei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationall.setTextColor(Color.GRAY);
                locationgangtai.setTextColor(Color.GRAY);
                locationhanguo.setTextColor(Color.GRAY);
                locationjapan.setTextColor(Color.GRAY);
                locationneidi.setTextColor(Color.GRAY);
                locationomei.setTextColor(Color.BLACK);
                whichlocationselect.setText(locationomei.getText());
            }
        });
        sexall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexall.setTextColor(Color.BLACK);
                sexman.setTextColor(Color.GRAY);
                sexwomen.setTextColor(Color.GRAY);
                sexzuhe.setTextColor(Color.GRAY);
                whichsexselect.setText(sexall.getText());
            }
        });
        sexman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexall.setTextColor(Color.GRAY);
                sexman.setTextColor(Color.BLACK);
                sexwomen.setTextColor(Color.GRAY);
                sexzuhe.setTextColor(Color.GRAY);
                whichsexselect.setText(sexman.getText());
            }
        });
        sexwomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexall.setTextColor(Color.GRAY);
                sexman.setTextColor(Color.GRAY);
                sexwomen.setTextColor(Color.BLACK);
                sexzuhe.setTextColor(Color.GRAY);
                whichsexselect.setText(sexwomen.getText());
            }
        });
        sexzuhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sexall.setTextColor(Color.GRAY);
                sexman.setTextColor(Color.GRAY);
                sexwomen.setTextColor(Color.GRAY);
                sexzuhe.setTextColor(Color.BLACK);
                whichsexselect.setText(sexzuhe.getText());
            }
        });
        styleall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                styleall.setTextColor(Color.BLACK);
                styledianzi.setTextColor(Color.GRAY);
                stylejueshi.setTextColor(Color.GRAY);
                styleliuxing.setTextColor(Color.GRAY);
                stylexiha.setTextColor(Color.GRAY);
                styleyaogun.setTextColor(Color.GRAY);
                whichstyleselect.setText(styleall.getText());
            }
        });
        styledianzi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                styleall.setTextColor(Color.GRAY);
                styledianzi.setTextColor(Color.BLACK);
                stylejueshi.setTextColor(Color.GRAY);
                styleliuxing.setTextColor(Color.GRAY);
                stylexiha.setTextColor(Color.GRAY);
                styleyaogun.setTextColor(Color.GRAY);
                whichstyleselect.setText(styledianzi.getText());
            }
        });
        stylejueshi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                styleall.setTextColor(Color.GRAY);
                styledianzi.setTextColor(Color.GRAY);
                stylejueshi.setTextColor(Color.BLACK);
                styleliuxing.setTextColor(Color.GRAY);
                stylexiha.setTextColor(Color.GRAY);
                styleyaogun.setTextColor(Color.GRAY);
                whichstyleselect.setText(stylejueshi.getText());
            }
        });
        styleliuxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                styleall.setTextColor(Color.GRAY);
                styledianzi.setTextColor(Color.GRAY);
                stylejueshi.setTextColor(Color.GRAY);
                styleliuxing.setTextColor(Color.BLACK);
                stylexiha.setTextColor(Color.GRAY);
                styleyaogun.setTextColor(Color.GRAY);
                whichstyleselect.setText(styleliuxing.getText());
            }
        });
        stylexiha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                styleall.setTextColor(Color.GRAY);
                styledianzi.setTextColor(Color.GRAY);
                stylejueshi.setTextColor(Color.GRAY);
                styleliuxing.setTextColor(Color.GRAY);
                stylexiha.setTextColor(Color.BLACK);
                styleyaogun.setTextColor(Color.GRAY);
                whichstyleselect.setText(stylexiha.getText());
            }
        });
        styleyaogun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                styleall.setTextColor(Color.GRAY);
                styledianzi.setTextColor(Color.GRAY);
                stylejueshi.setTextColor(Color.GRAY);
                styleliuxing.setTextColor(Color.GRAY);
                stylexiha.setTextColor(Color.GRAY);
                styleyaogun.setTextColor(Color.BLACK);
                whichstyleselect.setText(styleyaogun.getText());
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager=getFragmentManager(); FragmentTransaction transaction = manager.beginTransaction();//获取fragment
                //transaction.add(R.id.ly_under,new things());
                transaction.replace(R.id.ly_center, new Searchmusicfgment());//调用fragment中的事物进行动态操作add添加资源id的对象
//提交事物
                transaction.commit();
            }
        });
        return view;
    }

    private void initsongerlist() {
        okHttpClient=new OkHttpClient();
        for(int i=0;i<20;i++){
            Request.Builder builder=new Request.Builder();
            Request request=null;
            if(i%9==0) {
                 request = builder.get().url("http://img4.duitang.com/uploads/item/201510/21/20151021232843_zjnHR.thumb.224_0.jpeg").build();
            }else if(i%3==0){
                request = builder.get().url("http://cdnq.duitang.com/uploads/item/201502/22/20150222180556_kxEHj.thumb.224_0.jpeg").build();
            }else if(i%5==0){
                request = builder.get().url("http://i0.itc.cn/20140317/31fc_cb8942c6_d280_db5a_a0c9_fe02c2808191_1.jpg").build();
            }else if(i%7==0){
                request = builder.get().url("http://down.qnwz.cn/uploads/userup/511186/13012Q21426-3N8-0.jpg").build();
            }else {
                request = builder.get().url(" http://img.hb.aicdn.com/c7ef0745325a55ee94dd5912acb8ed8f1923cbef2f58-YeBlaM_fw658").build();
            }
            Call call=okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    InputStream inputStream=response.body().byteStream();
                    final Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                    Songer apple=new Songer(bitmap,"周杰伦");
                    songerlist.add(apple);
                }
            });
        }
        SongerAdapter adapter=new SongerAdapter(getActivity(),R.layout.songersortitem,songerlist);
        listview.setAdapter(adapter);
    }
}
