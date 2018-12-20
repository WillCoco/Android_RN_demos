package com.headless.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.facebook.react.views.image.GlobalImageLoadListener;

import javax.annotation.Nullable;

//import android.widget.TextView;

public class FloatWindow extends View {
    private @Nullable GlobalImageLoadListener mGlobalImageLoadListener;

    public FloatWindow(Context context) {
        super(context);
        Log.i("Tag 重写textview onDraw", "重写textview");

    }

    protected void onDraw(Canvas canvas) {
    }
}

