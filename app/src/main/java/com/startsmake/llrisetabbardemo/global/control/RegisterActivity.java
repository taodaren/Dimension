package com.startsmake.llrisetabbardemo.global.control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.startsmake.llrisetabbardemo.R;
import com.startsmake.llrisetabbardemo.global.bean.RegisterCodeBean;
import com.startsmake.llrisetabbardemo.global.util.HttpMethods;

import rx.Observer;


public class RegisterActivity extends AppCompatActivity {
    private static final String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setTitle();
        setClickListener();
    }

    private void setTitle() {
        //隐藏左侧点击事件
        ImageView ibMine = (ImageView) findViewById(R.id.img_mi_tab);
        ibMine.setVisibility(View.GONE);

        //设置标题
        TextView textTitle = (TextView) findViewById(R.id.text_title_tab);
        textTitle.setText("注册");
    }

    private void setClickListener() {
        //获取验证码
        findViewById(R.id.btn_get_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getRegisterCodeData();
            }
        });
        //注册完成
        findViewById(R.id.btn_over).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void getRegisterCodeData() {
        HttpMethods.getInstance().getRegisterCode(new Observer<RegisterCodeBean>() {
            @Override
            public void onCompleted() {
                Log.d("xns", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.e("xns", "error:" + e.getMessage());
            }

            @Override
            public void onNext(RegisterCodeBean registerCodeBean) {
                Log.d("xns", "bean:" + registerCodeBean);
            }
        }, "18641264225");
    }
}
