package com.startsmake.llrisetabbardemo.global;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.startsmake.llrisetabbardemo.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle();

    }

    private void setTitle() {
        //隐藏左侧点击事件
        ImageView ibMine = (ImageView) findViewById(R.id.img_mi_tab);
        ibMine.setVisibility(View.GONE);

        //设置标题
        TextView textTitle = (TextView) findViewById(R.id.text_title_tab);
        textTitle.setText("登录");

        //设置注册按钮
        TextView textRegister = (TextView) findViewById(R.id.text_title_register);
        textRegister.setText("注册");
        textRegister.setVisibility(View.VISIBLE);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
