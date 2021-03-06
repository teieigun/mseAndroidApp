package com.example.teiapp.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.MarginPageTransformer;

import com.example.teiapp.R;
import com.example.teiapp.adapter.ImageAdapter;
import com.example.teiapp.adapter.MultipleTypesAdapter;
import com.example.teiapp.bean.DataBean;
import com.example.teiapp.indicator.NumIndicator;
import com.example.teiapp.viewholder.VideoHolder;
import com.google.android.material.snackbar.Snackbar;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.util.BannerUtils;
import com.youth.banner.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 仿淘宝商品详情，banner第一个放视频,然后首尾不能自己滑动，加上自定义数字指示器
 * 视频地址：
 * https://www.jianshu.com/p/9db0fd1579b6
 */
public class VideoActivity extends AppCompatActivity {
    @BindView(R.id.banner)
    Banner banner;
    StandardGSYVideoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ButterKnife.bind(this);

        ImageAdapter adapter = new ImageAdapter(DataBean.getTestData2());
        banner.setAdapter(adapter)
                .addBannerLifecycleObserver(this)//添加生命周期观察者
                .setIndicator(new CircleIndicator(this))//设置指示器
                .setOnBannerListener((data, position) -> {
                    Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
                    LogUtils.d("position：" + position);
                });
        banner.addPageTransformer(new MarginPageTransformer((int) BannerUtils.dp2px(10)));

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
                        Log.e("--","position:"+position);
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
