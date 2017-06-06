package com.startsmake.llrisetabbardemo.activity;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.startsmake.llrisetabbardemo.R;

//import cn.bingoogolapple.qrcode.core.QRCodeView;

/**
 * 首页 → 二维码
 */
public class HomeQRCodeActivity extends AppCompatActivity /*implements QRCodeView.Delegate */{
    private static final String TAG = HomeQRCodeActivity.class.getSimpleName();
//    private QRCodeView qrCodeView;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_qrcode);

//        qrCodeView = (QRCodeView) findViewById(R.id.z_bar_view);
//        qrCodeView.setDelegate(this);
    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        qrCodeView.startCamera();
//        qrCodeView.showScanRect();
//    }
//
//    @Override
//    protected void onStop() {
//        qrCodeView.stopCamera();
//        super.onStop();
//    }
//
//    @Override
//    protected void onDestroy() {
//        qrCodeView.onDestroy();
//        super.onDestroy();
//    }
//
//    /**
//     * 处理扫描结果
//     */
//    @Override
//    public void onScanQRCodeSuccess(String result) {
//        Log.i(TAG, "result: " + result);
//        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
//        vibrate();
//        qrCodeView.startSpot();
//    }
//
//    private void vibrate() {
//        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
//        vibrator.vibrate(200);
//    }
//
//    /**
//     * 处理打开相机出错
//     */
//    @Override
//    public void onScanQRCodeOpenCameraError() {
//        Log.e(TAG, "打开相机出错！");
//    }
}
