package com.startsmake.llrisetabbardemo.global;

import android.app.Application;
import android.content.Context;

import com.yixia.camera.VCamera;

import java.io.File;

public class VideoApplication extends Application {
    public static String VIDEO_PATH = "/sdcard/video_cache/";

    @Override
    public void onCreate() {
        super.onCreate();

        VIDEO_PATH += String.valueOf(System.currentTimeMillis());
        File file = new File(VIDEO_PATH);
        if (!file.exists()) file.mkdirs();

        //设置视频缓存路径
        VCamera.setVideoCachePath(VIDEO_PATH);

        //开启log输出,ffmpeg输出到logcat
        VCamera.setDebugMode(true);

        //初始化拍摄SDK，必须
        VCamera.initialize(this);

        File dir = getApplicationContext().getDir("l  ibs", Context.MODE_PRIVATE);
        File[] currentFiles;
        currentFiles = dir.listFiles();
        for (int i = 0; i < currentFiles.length; i++) {
            System.load(currentFiles[i].getAbsolutePath());
        }
    }
}
