package com.startsmake.llrisetabbardemo.fragment;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.startsmake.llrisetabbardemo.R;
import com.startsmake.llrisetabbardemo.activity.HomeMsgActivity;
import com.startsmake.llrisetabbardemo.activity.HomeQRCodeActivity;
import com.startsmake.llrisetabbardemo.activity.MyDrawerActivity;

/**
 * 首页
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initTitle(view);
        return view;
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
        DrawerLayout drawerLayout = (DrawerLayout) view.findViewById(R.id.drawer_layout);


        view.findViewById(R.id.ib_mi_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "我的侧滑", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(), MyDrawerActivity.class);
                startActivity(intent);
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
        //设置 EditText 不自动弹出
        EditText editText = (EditText) view.findViewById(R.id.edit_shape);
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
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
        TextView textMsg = (TextView) view.findViewById(R.id.text_msg_home);
        textMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), HomeMsgActivity.class);
                startActivity(intent);
            }
        });
    }

}
