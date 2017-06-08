package com.startsmake.llrisetabbardemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.startsmake.llrisetabbardemo.R;
import com.startsmake.llrisetabbardemo.fragment.HomeFragment;
import com.startsmake.llrisetabbardemo.fragment.LeagueFragment;
import com.startsmake.llrisetabbardemo.fragment.SecondhandFragment;
import com.startsmake.llrisetabbardemo.fragment.WordFragment;
import com.startsmake.llrisetabbardemo.publish.PublishPopWindow;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_WORLD = "社区";
    private static final String TAG_PAGE_POST = "发布";
    private static final String TAG_PAGE_SECONDHAND = "二手交易";
    private static final String TAG_PAGE_LEAGUE = "社团";

    private MainNavigateTabBar mTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initTabBar(savedInstanceState);
    }

    private void initTabBar(Bundle savedInstanceState) {
        mTabBar = (MainNavigateTabBar) findViewById(R.id.mainTabBar);

        mTabBar.onRestoreInstanceState(savedInstanceState);

        mTabBar.addTab(HomeFragment.class, new MainNavigateTabBar
                .TabParam(R.mipmap.tab_home, R.mipmap.tab_home_selected, TAG_PAGE_HOME));
        mTabBar.addTab(WordFragment.class, new MainNavigateTabBar
                .TabParam(R.mipmap.tab_word, R.mipmap.tab_word_selected, TAG_PAGE_WORLD));
        mTabBar.addTab(null, new MainNavigateTabBar
                .TabParam(0, 0, TAG_PAGE_POST));
        mTabBar.addTab(SecondhandFragment.class, new MainNavigateTabBar
                .TabParam(R.mipmap.tab_secondhand, R.mipmap.tab_secondhand_selected, TAG_PAGE_SECONDHAND));
        mTabBar.addTab(LeagueFragment.class, new MainNavigateTabBar
                .TabParam(R.mipmap.tab_league, R.mipmap.tab_league_selected, TAG_PAGE_LEAGUE));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mTabBar.onSaveInstanceState(outState);
    }

    /**
     * 首页 → 发布
     */
    public void onClickPublish(View v) {
        PublishPopWindow popWindow = new PublishPopWindow(MainActivity.this);
        popWindow.showMoreWindow(v);

        //跳转小视频功能
//        Intent intent = new Intent(MainActivity.this, VideoActivity.class);
//        startActivity(intent);
    }
}
