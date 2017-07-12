package com.olacos.kunyu.secondhand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.olacos.kunyu.R;
import com.olacos.kunyu.global.internet.WebUrl;

import static com.olacos.kunyu.R.id.webView;

/**
 * 二手交易 → 筛选
 */
public class SortActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        initTitle();
        initWebView();
    }

    private void initTitle() {
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

    private void initWebView() {
        webView = (WebView) findViewById(R.id.web_sort);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(WebUrl.CATEGORY);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //按下返回键并且 webView 界面可以返回
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            //goBack()表示返回 WebView 的上一页面
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
