package com.example.teiapp.gridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.teiapp.R;

public class GridAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public GridAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    static class ViewHolder{
        public ImageView imageView;
        public TextView text01,text02,text03,text04;
    }


    //此方法极为重要，声明listview的每一行长什么样子
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view ==null){
            view = mLayoutInflater.inflate(R.layout.layout_grid_item,null);
            holder = new ViewHolder();
            holder.imageView =(ImageView)view.findViewById(R.id.gridViewInner01);
            holder.text01 =(TextView)view.findViewById(R.id.gridViewInnerText01);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.text01.setText("手机开发");
        Glide.with(mContext).load("https://www.google.co.jp/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png").into(holder.imageView);

        return view;
    }
}
