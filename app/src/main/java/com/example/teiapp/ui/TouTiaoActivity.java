package com.example.teiapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.example.teiapp.R;
import com.example.teiapp.adapter.TopLineAdapter;
import com.example.teiapp.bean.DataBean;
import com.youth.banner.Banner;
import com.youth.banner.transformer.ZoomOutPageTransformer;
import com.youth.banner.util.LogUtils;

public class TouTiaoActivity extends AppCompatActivity {
    @BindView(R.id.banner)
    Banner banner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tou_tiao);
        ButterKnife.bind(this);

        //实现1号店和淘宝头条类似的效果
        banner.setAdapter(new TopLineAdapter(DataBean.getTestData2()))
               .setOrientation(Banner.VERTICAL)
               .setPageTransformer(new ZoomOutPageTransformer())
               .setOnBannerListener((data, position) -> {
                   Snackbar.make(banner, ((DataBean) data).title, Snackbar.LENGTH_SHORT).show();
                   LogUtils.d("position：" + position);
               });

    }
}