package com.startsmake.llrisetabbardemo.global;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.startsmake.llrisetabbardemo.R;
import com.startsmake.llrisetabbardemo.home.HomeFragment;
import com.startsmake.llrisetabbardemo.league.LeagueFragment;
import com.startsmake.llrisetabbardemo.publish.control.PublishPopWindow;
import com.startsmake.llrisetabbardemo.secondhand.SecondhandFragment;
import com.startsmake.llrisetabbardemo.word.WordFragment;
import com.startsmake.mainnavigatetabbar.widget.MainNavigateTabBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        initClickListener();
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

    private void initClickListener() {
//        findViewById(R.id.mine_qr_code).setOnClickListener(this);
        findViewById(R.id.mine_avatar).setOnClickListener(this);
        findViewById(R.id.mine_set).setOnClickListener(this);

        findViewById(R.id.mine_praise).setOnClickListener(this);
        findViewById(R.id.mine_follow).setOnClickListener(this);
        findViewById(R.id.mine_fans).setOnClickListener(this);

        findViewById(R.id.mine_column).setOnClickListener(this);
        findViewById(R.id.mine_word).setOnClickListener(this);
        findViewById(R.id.mine_league).setOnClickListener(this);
        findViewById(R.id.mine_money).setOnClickListener(this);

        findViewById(R.id.mine_fa_huo).setOnClickListener(this);
        findViewById(R.id.mine_shou_huo).setOnClickListener(this);
        findViewById(R.id.mine_ping_jia).setOnClickListener(this);
        findViewById(R.id.mine_tui_huo).setOnClickListener(this);
        findViewById(R.id.mine_fa_bu).setOnClickListener(this);
        findViewById(R.id.mine_mai_chu).setOnClickListener(this);
        findViewById(R.id.mine_mai_dao).setOnClickListener(this);
        findViewById(R.id.mine_zan_guo).setOnClickListener(this);
    }

    /**
     * 首页 → 发布
     */
    public void onClickPublish(View v) {
        PublishPopWindow popWindow = new PublishPopWindow(MainActivity.this);
        popWindow.showMoreWindow(v);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.mine_qr_code:
//                Toast.makeText(this, "mine_qr_code", Toast.LENGTH_SHORT).show();
//                break;
            case R.id.mine_avatar:
                Toast.makeText(this, "avatar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_set:
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.mine_praise:
                Toast.makeText(this, "mine_praise", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_follow:
                Toast.makeText(this, "mine_follow", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_fans:
                Toast.makeText(this, "mine_fans", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_column:
                Toast.makeText(this, "mine_column", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_word:
                Toast.makeText(this, "mine_word", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_league:
                Toast.makeText(this, "mine_league", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_money:
                Toast.makeText(this, "mine_money", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_fa_huo:
                Toast.makeText(this, "mine_fa_huo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_shou_huo:
                Toast.makeText(this, "mine_shou_huo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_ping_jia:
                Toast.makeText(this, "mine_ping_jia", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_tui_huo:
                Toast.makeText(this, "mine_tui_huo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_fa_bu:
                Toast.makeText(this, "mine_fa_bu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_mai_chu:
                Toast.makeText(this, "mine_mai_chu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_mai_dao:
                Toast.makeText(this, "mine_mai_dao", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_zan_guo:
                Toast.makeText(this, "mine_zan_guo", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
}
