package com.empirejdesign.funnytoturial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.empirejdesign.funnytoturial.DemoFragment.DemoFragmentActivity;
import com.empirejdesign.funnytoturial.DemoGoogleMap.DemoGoogleMapsActivity;
import com.empirejdesign.funnytoturial.use3rdLiobraryAboutBanner.DemoBannerActivity;

import org.w3c.dom.Text;

import DemoPhotoAlbum.DemoPhotoAlbumActivity;
import DemoPhotoAlbum.PhotoTest;
import DemoPhotoAlbum.PhotoTest01;
import DemoPhotoAlbum.PhotoTest02;
import DemoPhotoAlbum.PhotoTest03;

public class MainActivity extends AppCompatActivity {

    private TextView mainBackButton;
    private Button enterDemoFragment;
    private Button enterGoogleMapFragment;
    private Button enterBanner;
    private Button enterPhotoAlbum;
    private Button enterPhotoTest;
    private Button enterPhotoTest01;
    private Button enterPhotoTest02;
    private Button enterPhotoTest03;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        mainBackButton = findViewById(R.id.mainBackButton);
        mainBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        enterDemoFragment = findViewById(R.id.enterDemoFragment);
        enterDemoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), DemoFragmentActivity.class);
                startActivity(intent);
                finish();
            }
        });
        enterGoogleMapFragment = findViewById(R.id.enterGoogleMapFragment);
        enterGoogleMapFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), DemoGoogleMapsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        enterBanner = findViewById(R.id.enterBanner);
        enterBanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), DemoBannerActivity.class);
                startActivity(intent);
                finish();
            }
        });

        enterPhotoAlbum = findViewById(R.id.enterPhotoAlbum);
        enterPhotoAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), DemoPhotoAlbumActivity.class);
                startActivity(intent);
                finish();
            }
        });



        enterPhotoTest = findViewById(R.id.enterPhotoTest);
        enterPhotoTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), PhotoTest.class);
                startActivity(intent);
                finish();
            }
        });

        enterPhotoTest01 = findViewById(R.id.enterPhotoTest01);
        enterPhotoTest01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), PhotoTest01.class);
                startActivity(intent);
                finish();
            }
        });


        enterPhotoTest02 = findViewById(R.id.enterPhotoTest02);
        enterPhotoTest02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), PhotoTest02.class);
                startActivity(intent);
                finish();
            }
        });

        enterPhotoTest03 = findViewById(R.id.enterPhotoTest03);
        enterPhotoTest03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), PhotoTest03.class);
                startActivity(intent);
                finish();
            }
        });



    }



}
