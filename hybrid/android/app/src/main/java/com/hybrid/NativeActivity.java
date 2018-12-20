package com.hybrid;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

//public class NativeActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_native);
////        hybrid();
//        startReact();
//    }
//
//    protected void hybrid() {
//        // 获取应用的Context
//        Context mContext = this.getApplicationContext();
//        // 获取WindowManager
//        WindowManager mWindowManager = (WindowManager) mContext
//                .getSystemService(Context.WINDOW_SERVICE);
//
//        View mView = setUpView(this);
//
//        final WindowManager.LayoutParams params = new WindowManager.LayoutParams();
//        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;
////        params.flags = WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE;
//        params.format = PixelFormat.TRANSLUCENT;
//        params.gravity = Gravity.CENTER;
//        params.width = 300;
//        params.height = 300;
//
//
//        mWindowManager.addView(mView, params);
//    }
//
//    private static View setUpView(final Context context) {
//        View view = LayoutInflater.from(context).inflate(R.layout.popupwindow, null);
//        return view;
//    }
//
//    private void startReact() {
//        ReactRootView mReactRootView = (ReactRootView) findViewById(R.id.rnview);
//        ReactInstanceManager mReactInstanceManager = ReactInstanceManager.builder()
//            .setApplication(getApplication())
//            .setBundleAssetName("index.android.bundle")
//            .setJSMainModulePath("index")
//            .addPackage(new MainReactPackage())
//            .setUseDeveloperSupport(BuildConfig.DEBUG)
//            .setInitialLifecycleState(LifecycleState.RESUMED)
////            .setUseOldBridge(true) // uncomment this line if your app crashes
//            .build();
//
//        mReactRootView.startReactApplication(mReactInstanceManager, "hybrid", null);
//        setContentView(mReactRootView);
//    }
//
//    @Override
//    public void invokeDefaultOnBackPressed() {
//        super.onBackPressed();
//    }
//}


public class NativeActivity extends AppCompatActivity implements DefaultHardwareBackBtnHandler {
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mReactRootView = findViewById(R.id.rnview);
//        mReactRootView = new ReactRootView(this);
        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModulePath("index")
                .addPackage(new MainReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();
        // 这个"App1"名字一定要和我们在index.js中注册的名字保持一致AppRegistry.registerComponent()
        mReactRootView.startReactApplication(mReactInstanceManager, "hybrid", null);
        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed() {
        super.onBackPressed();
    }

//
//    @Override
//    protected void onPause() {
//        super.onPause();
//
//        if (mReactInstanceManager != null) {
//            mReactInstanceManager.onHostPause(this);
//        }
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        if (mReactInstanceManager != null) {
//            mReactInstanceManager.onHostResume(this, this);
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (mReactInstanceManager != null) {
//            mReactInstanceManager.onBackPressed();
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//
//        if (mReactInstanceManager != null) {
//            mReactInstanceManager.onHostDestroy(this);
//        }
//        if (mReactRootView != null) {
//            mReactRootView.unmountReactApplication();
//        }
//    }

//    public boolean onKeyUp(int keyCode, KeyEvent event) {
//        if (BuildConfig.DEBUG) {
//            if (keyCode == KeyEvent.KEYCODE_MENU) {//Ctrl + M 打开RN开发者菜单
//                mReactInstanceManager.showDevOptionsDialog();
//                return true;
//            }
//        }
//        return super.onKeyUp(keyCode, event);
//    }

}

