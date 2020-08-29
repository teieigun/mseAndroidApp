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

        //找到按钮
        mBtnRadioButton =(Button)findViewById(R.id.button03);
        //增加此按钮的监听--用此按钮测试TextView
        mBtnRadioButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //由 Intent来协助完成 Android各个组件之间的通讯
                //Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                //startActivity(intent);
            }
        });
    }
    //--------------------------------------------------------------------------------------------//

}