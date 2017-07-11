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

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
            Disposable d;

            @Override
            public void onSubscribe(Disposable d) {
                this.d = d;
            }

            @Override
            public void onNext(RegisterCodeBean registerCodeBean) {
                Log.e(TAG, "onNext: 获取数据完成" + registerCodeBean);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString());
                d.dispose();
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete:");
                d.dispose();
            }
        });
    }
}
