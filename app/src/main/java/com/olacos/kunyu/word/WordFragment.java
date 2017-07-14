package com.olacos.kunyu.word;

import android.animation.LayoutTransition;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.olacos.kunyu.R;
import com.olacos.kunyu.global.control.SearchActivity;
import com.olacos.kunyu.global.internet.WebUrl;
import com.olacos.kunyu.global.util.GoTopScrollView;
import com.olacos.kunyu.mine.MineDrawerActivity;

/**
 * 社区
 */
public class WordFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        initTitle(view);
        initWebView(view);
        setBtnToTop(view, container);
        return view;
    }

    private void initWebView(View view) {
        final WebView webView = (WebView) view.findViewById(R.id.web_word);
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                //按下返回键并且 webView 界面可以返回
                if ((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            webView.goBack();
                        }
                    });
                    return true;
                }
                return false;
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(WebUrl.TAB_WORD);
    }

    private void initTitle(View view) {
        setMi(view);
        setShape(view);
//        setBackBtn(view);
    }

//    private void setBackBtn(View view) {
//        ImageView imgBack = (ImageView) view.findViewById(R.id.text_select_word);
//        imgBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().finish();
//            }
//        });
//    }

    private void setMi(View view) {
        ImageButton imgBtnMiHand = (ImageButton) view.findViewById(R.id.ib_mi_word);
        imgBtnMiHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击调出侧滑菜单（坑在 getActivity() 和 Gravity.LEFT）
//                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
//                drawerLayout.openDrawer(Gravity.LEFT);
                //跳转个人中心
                Intent intent = new Intent(getContext(), MineDrawerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setShape(View view) {
        LinearLayout layoutShape = (LinearLayout) view.findViewById(R.id.home_shape);
        layoutShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setBtnToTop(View view, ViewGroup container) {
        container = (LinearLayout) view.findViewById(R.id.layout_word);
        container.setLayoutTransition(new LayoutTransition());

        ImageButton imgBtnTop = (ImageButton) view.findViewById(R.id.goto_top_word);
        GoTopScrollView scrollView = (GoTopScrollView) view.findViewById(R.id.go_top_scroll_word);
        scrollView.setScrollListener(imgBtnTop);
    }
}
