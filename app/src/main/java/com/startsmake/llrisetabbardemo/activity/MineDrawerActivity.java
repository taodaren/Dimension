package com.startsmake.llrisetabbardemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.startsmake.llrisetabbardemo.R;

/**
 * 侧滑菜单：个人中心
 */
public class MineDrawerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_drawer);
        initClickListener();
    }

    private void initClickListener() {
        findViewById(R.id.mine_avatar).setOnClickListener(this);
        findViewById(R.id.mine_qr_code).setOnClickListener(this);

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

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_avatar:
                Toast.makeText(this, "avatar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_qr_code:
                Toast.makeText(this, "qrCode", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_praise:

                break;
            case R.id.mine_follow:

                break;
            case R.id.mine_fans:

                break;
            case R.id.mine_column:

                break;
            case R.id.mine_word:

                break;
            case R.id.mine_league:

                break;
            case R.id.mine_money:

                break;
            case R.id.mine_fa_huo:

                break;
            case R.id.mine_shou_huo:

                break;
            case R.id.mine_ping_jia:

                break;
            case R.id.mine_tui_huo:

                break;
            case R.id.mine_fa_bu:

                break;
            case R.id.mine_mai_chu:

                break;
            case R.id.mine_mai_dao:

                break;
            case R.id.mine_zan_guo:

                break;
            default:
        }
    }
}
