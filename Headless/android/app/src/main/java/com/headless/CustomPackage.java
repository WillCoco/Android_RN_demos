package com.headless;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.headless.Modules.LongTaskModule;
import com.headless.Modules.ToastModule;
import com.headless.views.BallViewManager;
import com.headless.views.ImageManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomPackage implements ReactPackage {

  @Override
  public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
    return Arrays.<ViewManager>asList(
            new ImageManager(),
            new BallViewManager()
    );
  }

  @Override
  public List<NativeModule> createNativeModules(
          ReactApplicationContext reactContext) {
    List<NativeModule> modules = new ArrayList<>();

    modules.add(new ToastModule(reactContext));
    modules.add(new LongTaskModule(reactContext));

    return modules;
  }

}