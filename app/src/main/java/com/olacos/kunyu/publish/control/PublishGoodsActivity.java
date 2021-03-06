package com.olacos.kunyu.publish.control;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.olacos.kunyu.R;
import com.olacos.kunyu.video.VideoActivity;

/**
 * PopWindow → 发布商品
 */
public class PublishGoodsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_goods);
        initTitle();
        setClickListener();
    }

    private void setClickListener() {
        findViewById(R.id.ll_goods_video).setOnClickListener(this);
        findViewById(R.id.layout_position).setOnClickListener(this);
        findViewById(R.id.add_img_left).setOnClickListener(this);
        findViewById(R.id.add_img_middle).setOnClickListener(this);
        findViewById(R.id.add_img_right).setOnClickListener(this);
        findViewById(R.id.checkbox_publish_goods).setOnClickListener(this);
        findViewById(R.id.btn_publish).setOnClickListener(this);
        findViewById(R.id.btn_cancel).setOnClickListener(this);
    }

    private void initTitle() {
        ImageView imgBack = (ImageView) findViewById(R.id.img_back);
        TextView textTitle = (TextView) findViewById(R.id.text_title);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(this);
        textTitle.setText("发布商品");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_goods_video:
                //跳转小视频
                Intent intent = new Intent(this, VideoActivity.class);
                startActivity(intent);
                break;
            case R.id.layout_position:
                setCitySelected();
                break;
            case R.id.add_img_left:
                break;
            case R.id.add_img_middle:
                break;
            case R.id.add_img_right:
                break;
            case R.id.checkbox_publish_goods:
                break;
            case R.id.btn_publish:
                break;
            case R.id.btn_cancel:
                break;
            case R.id.img_back:
                finish();
                break;
            default:
                break;
        }
    }

    private void setCitySelected() {
        CityPicker cityPicker = new CityPicker.Builder(this).textSize(20)
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

                TextView textCity = (TextView) findViewById(R.id.text_publish_city);
                TextView textArea = (TextView) findViewById(R.id.text_publish_area);
                textCity.setText(city);
                textArea.setText(district);
            }

            @Override
            public void onCancel() {
                Toast.makeText(PublishGoodsActivity.this, "已取消", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
