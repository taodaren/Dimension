package com.olacos.kunyu.secondhand;

import android.animation.LayoutTransition;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.olacos.kunyu.global.util.GoTopScrollView;
import com.olacos.kunyu.R;

/**
 * 二手交易
 */
public class SecondhandFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_secondhand, container, false);
        initTitle(view);
        setBtnToTop(view, container);
        return view;
    }

    private void initTitle(View view) {
        setMi(view);
        setShape(view);
        setSelect(view);
    }

    private void setSelect(View view) {
        TextView textSelect = (TextView) view.findViewById(R.id.text_select_hand);
        textSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SortActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setShape(View view) {
        EditText editFind = (EditText) view.findViewById(R.id.edit_shape);
        ImageView imgFind = (ImageView) view.findViewById(R.id.img_shape);
        imgFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "跳转到搜索界面", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setMi(View view) {
        ImageButton imgBtnMiHand = (ImageButton) view.findViewById(R.id.ib_mi_hand);
        imgBtnMiHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击调出侧滑菜单（坑在 getActivity() 和 Gravity.LEFT）
                DrawerLayout drawerLayout = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }

    private void setBtnToTop(View view, ViewGroup container) {
        container = (RelativeLayout) view.findViewById(R.id.rl_secondhand);
        container.setLayoutTransition(new LayoutTransition());

        ImageButton imgBtnTop = (ImageButton) view.findViewById(R.id.goto_top_secondhand);
        GoTopScrollView scrollView = (GoTopScrollView) view.findViewById(R.id.go_top_scroll_secondhand);
        scrollView.setScrollListener(imgBtnTop);
    }
}