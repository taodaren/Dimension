package com.startsmake.llrisetabbardemo.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.startsmake.llrisetabbardemo.R;

/**
 * 首页 → 消息
 */
public class HomeMsgActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_msg);
        initTitle();
    }

    private void initTitle() {
        TextView textTitle = (TextView) findViewById(R.id.text_title);
        textTitle.setText("消息");

        ImageView imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
