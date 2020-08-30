package com.example.teiapp;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

//我要在这里测试各种控件 对应的画面 activity_regist_user_info.xml
public class RegistUserInfoActivity extends AppCompatActivity {

    //用Radio按钮实现性别的选择
    private RadioGroup mRg1;
    //用Radio按钮实现最高学历的选择
    private RadioGroup mRg2;
    //用Checkbox按钮实现(您感兴趣的IT技术)的选择
    private CheckBox mCg1;
    private CheckBox mCg2;
    private CheckBox mCg3;
    private CheckBox mCg4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist_user_info);

        // 用Radio按钮实现性别的选择
        mRg1 = (RadioGroup) findViewById(R.id.radio01);
        mRg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int chechedId) {
                RadioButton radioButton = (RadioButton)group.findViewById(chechedId);
                Toast.makeText(RegistUserInfoActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        // 用Radio按钮实现最高学历的选择
        mRg2 = (RadioGroup) findViewById(R.id.radio02);
        mRg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int chechedId) {
                RadioButton radioButton = (RadioButton)group.findViewById(chechedId);
                Toast.makeText(RegistUserInfoActivity.this,radioButton.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        // 用Radio按钮实现最高学历的选择
        mCg1 = (CheckBox) findViewById(R.id.skillCheckBox01);
        mCg1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Toast.makeText(RegistUserInfoActivity.this,isChecked?"Java选中":"Java未选中",Toast.LENGTH_SHORT).show();
            }
        });
        mCg2 = (CheckBox) findViewById(R.id.skillCheckBox02);
        mCg2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Toast.makeText(RegistUserInfoActivity.this,isChecked?"Php选中":"Php未选中",Toast.LENGTH_SHORT).show();
            }
        });
        mCg3 = (CheckBox) findViewById(R.id.skillCheckBox03);
        mCg3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Toast.makeText(RegistUserInfoActivity.this,isChecked?"Android选中":"Android未选中",Toast.LENGTH_SHORT).show();
            }
        });
        mCg4 = (CheckBox) findViewById(R.id.skillCheckBox04);
        mCg4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Toast.makeText(RegistUserInfoActivity.this,isChecked?"IOS选中":"IOS未选中",Toast.LENGTH_SHORT).show();
            }
        });

        }
    }

