package com.hybrid.Modules;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class SetActivity extends ReactContextBaseJavaModule {

    Activity mainActivity;

    public SetActivity(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return "IntentModule";
    }

    @ReactMethod
    public void startActivityFromJS(String name) {
        try{
            mainActivity = getCurrentActivity();
            if(null!=mainActivity){
                Class toActivity = Class.forName(name);
                Intent intent = new Intent(mainActivity,toActivity);
//                intent.putExtra("params", params);
                mainActivity.startActivity(intent);
            }
        }catch(Exception e){
            throw new JSApplicationIllegalArgumentException(
                    "不能打开Activity : "+e.getMessage());
        }
    }

    @ReactMethod
    public void backActivityFromJS(String name) {
        try{
            Activity currentActivity = getCurrentActivity();
            if(null!=currentActivity){
                Class toActivity = Class.forName(name);
                Intent intent = new Intent(mainActivity,toActivity);
//                intent.putExtra("params", params);
                currentActivity.startActivity(intent);
            }
        }catch(Exception e){
            throw new JSApplicationIllegalArgumentException(
                    "不能回退Activity : "+e.getMessage());
        }
    }
}
