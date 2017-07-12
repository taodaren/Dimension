package com.olacos.kunyu.global.util;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.olacos.kunyu.R;

/**
 * 自定义控件 置顶按钮
 */

public class GoTopScrollView extends ScrollView implements View.OnClickListener {
    private ImageView goTopBtn;

    public GoTopScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollListener(ImageView goTopBtn) {
        this.goTopBtn = goTopBtn;
        this.goTopBtn.setOnClickListener(this);
    }

    @Override
    protected void onScrollChanged(int l, int t, int old_l, int old_t) {
        super.onScrollChanged(l, t, old_l, old_t);
        //滑动距离超过 800px 出现向上按钮,可以做为自定义属性
        if (t >= 800) {
            goTopBtn.setVisibility(VISIBLE);
        } else {
            goTopBtn.setVisibility(GONE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goto_top_home:
            case R.id.goto_top_word:
            case R.id.goto_top_secondhand:
            case R.id.goto_top_league:
                this.smoothScrollTo(0, 0);
                break;
        }
    }
}
