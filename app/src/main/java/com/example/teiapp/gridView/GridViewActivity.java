package com.example.teiapp.gridView;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListView;

import com.example.teiapp.R;
import com.example.teiapp.listView.ListAdapter;

import static com.example.teiapp.R.layout.activity_gridview;
import static com.example.teiapp.R.layout.activity_listview;

public class GridViewActivity extends Activity {

    private GridView mGv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_gridview);
        mGv1 = (GridView) findViewById(R.id.gridViewOut01);
        mGv1.setAdapter(new GridAdapter(GridViewActivity.this));
    }
}