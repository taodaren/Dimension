package com.startsmake.llrisetabbardemo.word;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.startsmake.llrisetabbardemo.R;

/**
 * 社区
 */
public class WordFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word, container, false);
        initTitle(view);
        initShape(view);
        return view;
    }

    private void initShape(View view) {
        EditText editFind = (EditText) view.findViewById(R.id.edit_tab_shape);
        editFind.setHint("社团活动、搜索");

        ImageView imgFind = (ImageView) view.findViewById(R.id.img_tab_shape);
        imgFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "跳转到搜索界面", Toast.LENGTH_SHORT).show();
            }
        });
    }

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
        textTitle.setText("社区");
    }
}
