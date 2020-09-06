package com.example.teiapp.viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.teiapp.R;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager0;
    private ArrayList<View> aList;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_zero);
        viewPager0 = (ViewPager) findViewById(R.id.viewPager0);

        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.activity_viewpager_one,null,false));
        aList.add(li.inflate(R.layout.activity_viewpager_two,null,false));
        aList.add(li.inflate(R.layout.activity_viewpager_three,null,false));
        mAdapter = new ViewPagerAdapter(aList);
        viewPager0.setAdapter(mAdapter);
    }
}