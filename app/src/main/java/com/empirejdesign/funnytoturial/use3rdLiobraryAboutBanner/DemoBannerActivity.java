package com.empirejdesign.funnytoturial.use3rdLiobraryAboutBanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.empirejdesign.funnytoturial.R;
import com.ms.banner.Banner;
import com.ms.banner.holder.BannerViewHolder;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DemoBannerActivity extends AppCompatActivity {

    Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_banner);

        ArrayList<String> input = new ArrayList<String>();
        input.add("111");
        input.add("222");
        input.add("333");

        banner = (Banner) findViewById(R.id.banner);
        banner.setAutoPlay(true)
                .setPages(input, new CustomViewHolder())
                .start();
    }

    @Override
    protected void onStart() {
        super.onStart();
        //开始轮播
        if (banner != null && banner.isPrepare() && !banner.isStart()) {
            banner.startAutoPlay();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        //结束轮播
        if (banner != null && banner.isPrepare() && banner.isStart()) {
            banner.stopAutoPlay();
        }
    }

    class CustomViewHolder implements BannerViewHolder<String> {

        @Override
        public View createView(Context context, int position, String data) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
            TextView bannerItem_text = view.findViewById(R.id.bannerItem_text);
            ImageView bannerItem_image= view.findViewById(R.id.bannerItem_image);
            String temp = "第"+position+"頁"+data;
            bannerItem_text.setText(temp);

            return view;
        }
    }
}
