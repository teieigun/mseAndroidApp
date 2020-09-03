package com.example.teiapp.listView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.teiapp.R;

import static com.example.teiapp.R.layout.activity_listview;
import static com.example.teiapp.R.layout.layout_list_item;

public class ListViewActivity extends Activity {

    private ListView mLv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_listview);
        mLv1 = (ListView) findViewById(R.id.listViewOut01);
        mLv1.setAdapter(new ListAdapter(ListViewActivity.this));
    }
}