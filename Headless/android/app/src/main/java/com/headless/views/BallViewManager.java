package com.headless.views;

import android.view.View;

import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;

public class BallViewManager extends SimpleViewManager<View> {

    public static final String REACT_CLASS = "RCTFloatWindow";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

//    @Override
//    public ReactImageView createViewInstance(ThemedReactContext context) {
//        return new ReactImageView(context, Fresco.newDraweeControllerBuilder(), null, null);
//    }

    @Override
    public View createViewInstance(ThemedReactContext context) {
        return new BallView(context);
    }

    @ReactProp(name = "borderRadius", defaultFloat = 0f)
    public void setBorderRadius(ReactImageView view, float borderRadius) {
        view.setBorderRadius(borderRadius);
    }

}