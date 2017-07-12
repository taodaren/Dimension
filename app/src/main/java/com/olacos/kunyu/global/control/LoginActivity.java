package com.olacos.kunyu.global.control;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.olacos.kunyu.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_REGISTER = 0;

    private Button btnLogin;
    private TextView textWeiXin, textQQ, textWeiBo;
    private EditText editAccount, editPassword;

    private UMShareAPI mShareAPI = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle();
        initView();
        //首先获取UMShareAPI
        mShareAPI = UMShareAPI.get(this);
    }

    private void setTitle() {
        //隐藏左侧点击事件
        ImageView ibMine = (ImageView) findViewById(R.id.img_mi_tab);
        ibMine.setVisibility(View.GONE);

        //设置标题
        TextView textTitle = (TextView) findViewById(R.id.text_title_tab);
        textTitle.setText("登录");

        //设置注册按钮
        TextView textRegister = (TextView) findViewById(R.id.text_title_register);
        textRegister.setText("注册");
        textRegister.setVisibility(View.VISIBLE);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        btnLogin = (Button) findViewById(R.id.btn_login);
        editAccount = (EditText) findViewById(R.id.edit_account_login);
        editPassword = (EditText) findViewById(R.id.edit_password_login);
        textWeiXin = (TextView) findViewById(R.id.text_wei_xin);
        textQQ = (TextView) findViewById(R.id.text_qq);
        textWeiBo = (TextView) findViewById(R.id.text_wei_bo);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        textWeiXin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取用户信息
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.WEIXIN, umAuthListener);
            }
        });

        textQQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.QQ, umAuthListener);
            }
        });

        textWeiBo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShareAPI.getPlatformInfo(LoginActivity.this, SHARE_MEDIA.SINA, umAuthListener);
            }
        });
    }

    public void login() {
        //如果没有验证成功，登录失败
        if (!validate()) {
            onLoginFailed();
            return;
        }

        btnLogin.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("登录中...");
        progressDialog.show();

        String account = editAccount.getText().toString();
        String password = editPassword.getText().toString();

        //发送网络请求

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        //完成调用 onLoginSuccess 或 onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_REGISTER) {
            if (resultCode == RESULT_OK) {

                //TODO: 在这里实现成功的注册逻辑
                UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
                //默认情况下，我们刚刚完成活动并自动登录
                this.finish();
            }
        }
    }

    public void onLoginSuccess() {
        btnLogin.setEnabled(true);
        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "登录失败", Toast.LENGTH_LONG).show();
        btnLogin.setEnabled(true);
    }

    /**
     * 验证用户信息
     *
     * @return 验证结果
     */
    public boolean validate() {
        //是否有效
        boolean valid = true;

        String account = editAccount.getText().toString();
        String password = editPassword.getText().toString();

        //判断手机号
        if (account.isEmpty() || !(account.length() == 11) || !(isMobileNO(account))) {
            editAccount.setError("请输入一个有效的手机号");
            valid = false;
        } else {
            editAccount.setError(null);
        }

        //判断密码
        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            editPassword.setError("4到10个字母、数字或字符");
            valid = false;
        } else {
            editPassword.setError(null);
        }

        return valid;
    }

    //验证手机号是否为正确手机号
    public static boolean isMobileNO(String mobiles) {

        Pattern p = Pattern
                .compile("^(0|86|17951)?(13[0-9]|15[0-9]|17[0-9]|18[0-9]|14[0-9])[0-9]{8}$");
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }

    /**
     * 授权回调
     */
    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA share_media) {
            //授权开始的回调
        }

        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            Toast.makeText(getApplicationContext(), "授权成功", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            Toast.makeText( getApplicationContext(), "授权失败", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            Toast.makeText( getApplicationContext(), "取消授权", Toast.LENGTH_SHORT).show();
        }
    };

}
