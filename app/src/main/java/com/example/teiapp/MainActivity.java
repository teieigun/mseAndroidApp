package com.example.teiapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teiapp.adapter.MultipleTypesAdapter;
import com.example.teiapp.bean.DataBean;
import com.example.teiapp.gridView.GridViewActivity;
import com.example.teiapp.indicator.NumIndicator;
import com.example.teiapp.listView.ListViewActivity;
import com.example.teiapp.recyclerView.RecyclerViewActivity;
import com.example.teiapp.viewholder.VideoHolder;
import com.example.teiapp.viewpager.ViewPagerActivity;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.listener.OnPageChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Button mBtnButton;
    private Button mBtnButtonForEditText;
    private Button mRadioButton;
    private Button mGridButton;
    private Button mViewPagerButton;
    private Button mRecylerViewButton;

    @BindView(R.id.banner)
    Banner banner;
    StandardGSYVideoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //banner
        ButterKnife.bind(this);

        banner.addBannerLifecycleObserver(this)
                .setAdapter(new MultipleTypesAdapter(this, DataBean.getTestDataVideo()))
                .setIndicator(new NumIndicator(this))
                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                .addOnPageChangeListener(new OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        Log.e("--", "position:" + position);
                        if (player == null) {
                            RecyclerView.ViewHolder viewHolder = banner.getAdapter().getViewHolder();
                            if (viewHolder instanceof VideoHolder) {
                                VideoHolder holder = (VideoHolder) viewHolder;
                                player = holder.player;
                            }
                            return;
                        }
                        if (position != 0) {
                            player.onVideoReset();
                        }
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });

        //找到按钮
        mBtnButton = (Button) findViewById(R.id.button01);
        mBtnButtonForEditText = (Button) findViewById(R.id.button02);
        mRadioButton = (Button) findViewById(R.id.button03);
        mGridButton = (Button) findViewById(R.id.button04);
        mViewPagerButton = (Button) findViewById(R.id.button05);
        mRecylerViewButton = (Button) findViewById(R.id.button06);
        setListeners();
    }

    private void setListeners(){
        OnClick onClick = new OnClick();
        mBtnButton.setOnClickListener(onClick);
        mBtnButtonForEditText.setOnClickListener(onClick);
        mRadioButton.setOnClickListener(onClick);
        mGridButton.setOnClickListener(onClick);
        mViewPagerButton.setOnClickListener(onClick);
        mRecylerViewButton.setOnClickListener(onClick);
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
                case R.id.button06:
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (player != null)
            player.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (player != null)
            player.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        //释放所有
        if (player != null)
            player.setVideoAllCallBack(null);
        super.onBackPressed();
    }
}

