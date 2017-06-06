package com.startsmake.llrisetabbardemo.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.startsmake.llrisetabbardemo.R;

/**
 * 社团
 */
public class LeagueFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_league, container, false);
        initTitle(view);
        initShape(view);
        return view;
    }

    private void initShape(View view) {
        EditText editFind = (EditText) view.findViewById(R.id.edit_tab_shape);
        editFind.setHint("热帖搜索");

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
                Toast.makeText(getContext(), "跳转我的侧滑", Toast.LENGTH_SHORT).show();
            }
        });

        TextView textTitle = (TextView) view.findViewById(R.id.text_title_tab);
        textTitle.setText("社团");
    }
}
