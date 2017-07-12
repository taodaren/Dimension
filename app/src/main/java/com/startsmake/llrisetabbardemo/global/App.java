package com.startsmake.llrisetabbardemo.global;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by Administrator on 2017/7/12.
 */

public class App extends Application {
    {
        PlatformConfig.setWeixin("wx3f1c60dd769efa08", "8bdd44733375997abd8b53e54ed0c5c7");
        PlatformConfig.setQQZone("1105486839", "XxGi7pKfMbGjOYsi");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
}
