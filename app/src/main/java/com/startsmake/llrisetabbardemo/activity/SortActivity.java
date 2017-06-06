package com.startsmake.llrisetabbardemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.startsmake.llrisetabbardemo.R;

/**
 * 二手交易 → 筛选
 */
public class SortActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        TextView textTitle = (TextView) findViewById(R.id.text_title);
        textTitle.setText("分类");
        final ImageView imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
