package com.olacos.kunyu.global;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import com.yixia.camera.VCamera;

import java.io.File;

/**
 * Created by Administrator on 2017/7/12.
 */

public class MyApplication extends Application {
    public static String VIDEO_PATH = "/sdcard/WeiXinRecordedDemo/";

    {
        PlatformConfig.setWeixin("wx3f1c60dd769efa08", "8bdd44733375997abd8b53e54ed0c5c7");
        PlatformConfig.setQQZone("1105486839", "XxGi7pKfMbGjOYsi");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
        VIDEO_PATH += String.valueOf(System.currentTimeMillis());
        File file = new File(VIDEO_PATH);
        if (!file.exists()) file.mkdirs();

        //设置视频缓存路径
        VCamera.setVideoCachePath(VIDEO_PATH);

        // 开启log输出,ffmpeg输出到logcat
        VCamera.setDebugMode(true);

        // 初始化拍摄SDK，必须
        VCamera.initialize(this);
    }
}
