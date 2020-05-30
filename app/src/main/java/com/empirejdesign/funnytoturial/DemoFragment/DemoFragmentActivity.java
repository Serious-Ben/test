package com.empirejdesign.funnytoturial.DemoFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.empirejdesign.funnytoturial.R;

public class DemoFragmentActivity extends AppCompatActivity {

    private FrameLayout demoFragFramelayout;
    private Button demoFragArea1;
    private Button demoFragArea2;
    private Button demoFragArea3;

    private FragmentManager fragmentManager;

    private Area1Fragment mArea1Fragment;
    private Area2Fragment mArea2Fragment;
    private Area3Fragment mArea3Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_fragment);

        initViews();

        initFragments();
    }

    private void initFragments() {
        fragmentManager = getSupportFragmentManager();
        mArea1Fragment = Area1Fragment.newInstance("","");
        mArea2Fragment = Area2Fragment.newInstance("","");
        mArea3Fragment = Area3Fragment.newInstance("","");

        FragmentTransaction tras = fragmentManager.beginTransaction();
        tras.add(R.id.demoFragFramelayout, mArea1Fragment);
        tras.commit();

        demoFragArea1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tras = fragmentManager.beginTransaction();
                tras.replace(R.id.demoFragFramelayout, mArea1Fragment);
                tras.addToBackStack(null);
                tras.commitAllowingStateLoss();
            }
        });
        demoFragArea2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tras = fragmentManager.beginTransaction();
                tras.replace(R.id.demoFragFramelayout, mArea2Fragment);
                tras.addToBackStack(null);
                tras.commitAllowingStateLoss();
            }
        });
        demoFragArea3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction tras = fragmentManager.beginTransaction();
                tras.replace(R.id.demoFragFramelayout, mArea3Fragment);
                tras.addToBackStack(null);
                tras.commitAllowingStateLoss();
            }
        });

    }

    private void initViews() {
        demoFragFramelayout = findViewById(R.id.demoFragFramelayout);
        demoFragArea1 = findViewById(R.id.demoFragArea1);
        demoFragArea2 = findViewById(R.id.demoFragArea2);
        demoFragArea3 = findViewById(R.id.demoFragArea3);
    }
}
