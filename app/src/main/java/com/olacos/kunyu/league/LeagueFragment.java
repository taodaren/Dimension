package com.olacos.kunyu.league;

import android.animation.LayoutTransition;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.olacos.kunyu.R;
import com.olacos.kunyu.global.internet.WebUrl;
import com.olacos.kunyu.global.util.GoTopScrollView;

/**
 * 社团
 */
public class LeagueFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_league, container, false);
        initTitle(view);
        initWebView(view);
//        initShape(view);
        setBtnToTop(view, container);
        return view;
    }

    private void initWebView(View view) {
        final WebView webView = (WebView) view.findViewById(R.id.web_league);
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
        webView.loadUrl(WebUrl.TAB_LEAGUE);
    }

//    private void initShape(View view) {
//        EditText editFind = (EditText) view.findViewById(R.id.edit_tab_shape);
//        editFind.setHint("热帖搜索");
//
//        ImageView imgFind = (ImageView) view.findViewById(R.id.img_tab_shape);
//        imgFind.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getContext(), "跳转到搜索界面", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    private void initTitle(View view) {
        ImageView imgMiTab = (ImageView) view.findViewById(R.id.img_mi_tab);
        imgMiTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击调出侧滑菜单（坑在 getActivity() 和 Gravity.LEFT）
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        TextView textTitle = (TextView) view.findViewById(R.id.text_title_tab);
        textTitle.setText("社团");
    }

    private void setBtnToTop(View view, ViewGroup container) {
        container = (RelativeLayout) view.findViewById(R.id.layout_league);
        container.setLayoutTransition(new LayoutTransition());

        ImageButton imgBtnTop = (ImageButton) view.findViewById(R.id.goto_top_league);
        GoTopScrollView scrollView = (GoTopScrollView) view.findViewById(R.id.go_top_scroll_league);
        scrollView.setScrollListener(imgBtnTop);
    }
}
