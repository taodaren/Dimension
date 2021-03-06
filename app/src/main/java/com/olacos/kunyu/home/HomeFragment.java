package com.olacos.kunyu.home;

import android.animation.LayoutTransition;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.olacos.kunyu.R;
import com.olacos.kunyu.global.control.SearchActivity;
import com.olacos.kunyu.global.internet.WebUrl;
import com.olacos.kunyu.global.util.GoTopScrollView;

/**
 * 首页
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initTitle(view);
        initWebView(view);
        setBtnToTop(view, container);
        return view;
    }

    private void initWebView(View view) {
        final WebView webView = (WebView) view.findViewById(R.id.web_home);
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
        webView.loadUrl(WebUrl.TAB_HOME);
    }

    private void initTitle(View view) {
        //我的侧滑
        setDrawer(view);
        //城市选择
        setCitySelected(view);
        //搜索
        setShape(view);
        //二维码扫描
        setQrCode(view);
        //消息
        setMessage(view);
    }

    private void setDrawer(View view) {
        ImageButton ibMine = (ImageButton) view.findViewById(R.id.ib_mi_home);
        ibMine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击调出侧滑菜单（坑在 getActivity() 和 Gravity.LEFT）
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void setCitySelected(View view) {
        view.findViewById(R.id.layout_city).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                CityPicker cityPicker = new CityPicker.Builder(getContext()).textSize(20)
                        .title("地址选择")
                        .backgroundPop(0xa0000000)
                        .titleBackgroundColor("#f7c936")
                        .titleTextColor("#ffffff")
                        .confirTextColor("#ffffff")
                        .cancelTextColor("#ffffff")
                        .province("吉林省")
                        .city("长春市")
                        .district("绿园区")
                        .textColor(Color.parseColor("#000000"))
                        .provinceCyclic(true)
                        .cityCyclic(false)
                        .districtCyclic(false)
                        .visibleItemsCount(7)
                        .itemPadding(10)
                        .onlyShowProvinceAndCity(false)
                        .build();
                cityPicker.show();

                //监听方法，获取选择结果
                cityPicker.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
                    @Override
                    public void onSelected(String... citySelected) {
                        //省份
                        String province = citySelected[0];
                        //城市
                        String city = citySelected[1];
                        //区县（如果设定了两级联动，那么该项返回空）
                        String district = citySelected[2];
                        //邮编
                        String code = citySelected[3];

                        TextView textCity = (TextView) view.findViewById(R.id.text_city);
                        textCity.setText(district);
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getContext(), "已取消", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

    private void setShape(View view) {
        LinearLayout layoutShape = (LinearLayout) view.findViewById(R.id.layout_shape_home);
        layoutShape.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
//        //设置 EditText 不自动弹出
//        view.findViewById(R.id.edit_shape).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getContext(), SearchActivity.class);
//                startActivity(intent);
//            }
//        });

//        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    private void setQrCode(View view) {
        TextView textQrCode = (TextView) view.findViewById(R.id.text_code_home);
        textQrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HomeQRCodeActivity.class));
            }
        });
    }

    private void setMessage(View view) {
        ImageButton ibMsg = (ImageButton) view.findViewById(R.id.ib_msg_home);
        ibMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), HomeMsgActivity.class));
            }
        });
    }

    private void setBtnToTop(View view, ViewGroup container) {
        container = (RelativeLayout) view.findViewById(R.id.rl_home);
        container.setLayoutTransition(new LayoutTransition());

        ImageButton imgBtnTop = (ImageButton) view.findViewById(R.id.goto_top_home);
        GoTopScrollView scrollView = (GoTopScrollView) view.findViewById(R.id.go_top_scroll_home);
        scrollView.setScrollListener(imgBtnTop);
    }
}
