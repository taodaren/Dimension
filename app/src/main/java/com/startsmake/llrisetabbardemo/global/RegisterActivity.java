package com.startsmake.llrisetabbardemo.global;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.startsmake.llrisetabbardemo.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle();
    }

    private void setTitle() {
        //隐藏左侧点击事件
        ImageView ibMine = (ImageView) findViewById(R.id.img_mi_tab);
        ibMine.setVisibility(View.GONE);

        //设置标题
        TextView textTitle = (TextView) findViewById(R.id.text_title_tab);
        textTitle.setText("注册");
    }
}
