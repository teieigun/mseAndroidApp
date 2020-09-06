package com.example.teiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.teiapp.gridView.GridViewActivity;
import com.example.teiapp.listView.ListViewActivity;
import com.example.teiapp.viewpager.ViewPagerActivity;


public class MainActivity extends AppCompatActivity {

    private Button mBtnButton;
    private Button mBtnButtonForEditText;
    private Button mRadioButton;
    private Button mGridButton;
    private Button mViewPagerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //--------------------------------------------------------------------------------------------//
        //找到按钮
        mBtnButton = (Button) findViewById(R.id.button01);
        mBtnButtonForEditText = (Button) findViewById(R.id.button02);
        mRadioButton = (Button) findViewById(R.id.button03);
        mGridButton = (Button) findViewById(R.id.button04);
        mViewPagerButton = (Button) findViewById(R.id.button05);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnButton.setOnClickListener(onClick);
        mBtnButtonForEditText.setOnClickListener(onClick);
        mRadioButton.setOnClickListener(onClick);
        mGridButton.setOnClickListener(onClick);
        mViewPagerButton.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.button01:
                    intent = new Intent(MainActivity.this, RegistUserInfoActivity.class);
                    break;
                case R.id.button02:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.button03:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.button04:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.button05:
                    intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

