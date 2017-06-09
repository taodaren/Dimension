package com.startsmake.llrisetabbardemo.publish;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import com.startsmake.llrisetabbardemo.R;

import java.util.Calendar;

/**
 * PopWindow → 发布活动
 */
public class PublishActivityActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_activity);
        initTitle();
        setTime();
    }

    /**
     * 设置开始/结束时间
     */
    private void setTime() {
        final TextView textTimeStart = (TextView) findViewById(R.id.text_time_start);
        final TextView textTimeOver = (TextView) findViewById(R.id.text_time_over);

        //获取 Calendar 对象，用于获取当前时间
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        //设置默认活动开始/结束时间
        textTimeStart.setText(year + "年" + (month + 1) + "月" + day + "日");
        textTimeOver.setText(year + "年" + (month + 1) + "月" + day + "日");

        //选择活动开始时间
        textTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerStart = new DatePickerDialog(PublishActivityActivity.this, new DatePickerDialog.OnDateSetListener() {
                    //选择完日期后会调用该回调函数
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        //因为 monthOfYear 会比实际月份少一月所以这边要加 1
                        textTimeStart.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                    }
                }, year, month, day);
                //弹出选择日期对话框
                datePickerStart.show();
            }
        });

        //选择活动结束时间
        textTimeOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerOver = new DatePickerDialog(PublishActivityActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                        textTimeOver.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日");
                    }
                }, year, month, day);
                datePickerOver.show();
            }
        });
    }

    private void initTitle() {
        TextView textTitle = (TextView) findViewById(R.id.text_title);
        textTitle.setText("发布活动");
        ImageView imgBack = (ImageView) findViewById(R.id.img_back);
        imgBack.setVisibility(View.VISIBLE);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
