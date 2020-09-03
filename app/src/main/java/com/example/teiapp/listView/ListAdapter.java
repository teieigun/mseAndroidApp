package com.example.teiapp.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.teiapp.R;

public class ListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public ListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
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
            view = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView =(ImageView)view.findViewById(R.id.adapterLv1);
            holder.text01 =(TextView)view.findViewById(R.id.text01);
            holder.text02 =(TextView)view.findViewById(R.id.text02);
            holder.text03 =(TextView)view.findViewById(R.id.text03);
            holder.text04 =(TextView)view.findViewById(R.id.text04);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        //给控件赋值
        holder.text01.setText("手机开发");
        holder.text02.setText("郑老师");
        holder.text03.setText("观看人数：2300人");
        holder.text04.setText("发布日:2010/02/04");

        return view;
    }
}
