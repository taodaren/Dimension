package com.olacos.kunyu.global.control;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.olacos.kunyu.R;
import com.olacos.kunyu.global.internet.WebUrl;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

//        initTitle();
        initWebView();
    }

//    private void initTitle() {
//        //后退
//        findViewById(R.id.img_back_search).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
//        //搜索
////        findViewById(R.id.shape_search).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Intent intent = new Intent(SearchActivity.this, SearchActivity.class);
////                startActivity(intent);
////            }
////        });
//    }

    private void initWebView() {
        WebView webView = (WebView) findViewById(R.id.web_search);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(WebUrl.SEARCH);
    }
}
