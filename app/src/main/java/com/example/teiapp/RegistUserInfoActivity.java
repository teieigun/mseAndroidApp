package com.example.teiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//我要在这里测试各种控件 对应的画面 activity_regist_user_info.xml
public class RegistUserInfoActivity extends AppCompatActivity {

    private Button mBtnRadioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_user_info);
    }

}