package com.example.teiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button mBtnButton;
    private Button mBtnButtonForEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //--------------------------------------------------------------------------------------------//
        //找到按钮
        mBtnButton =(Button)findViewById(R.id.button03);
        //增加此按钮的监听--用此按钮测试TextView
        mBtnButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //由 Intent来协助完成 Android各个组件之间的通讯
                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });

        //--------------------------------------------------------------------------------------------//
        mBtnButtonForEditText =(Button)findViewById(R.id.button02);
        //增加此按钮的监听--用此按钮测试EditText
        mBtnButtonForEditText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //由 Intent来协助完成 Android各个组件之间的通讯
                Intent intent = new Intent(MainActivity.this, EditTextActivity.class);
                startActivity(intent);
            }
        });
    }


}