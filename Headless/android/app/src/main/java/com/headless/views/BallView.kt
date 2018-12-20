package com.headless.views

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
//import android.widget.TextView;
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PixelFormat
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowManager

import com.facebook.drawee.controller.AbstractDraweeControllerBuilder
import com.facebook.drawee.view.GenericDraweeView
import com.facebook.react.views.image.GlobalImageLoadListener
import com.facebook.react.views.text.ReactTextView
import com.facebook.react.uimanager.ThemedReactContext;

import java.util.LinkedList

class BallView(context: ThemedReactContext) : View(context) {
    private val mGlobalImageLoadListener: GlobalImageLoadListener? = null

    init {
        Log.i("Tag Thread", Thread.currentThread().name)

        val activity = context.getCurrentActivity()

        val w = activity?.window
        val attributes = w?.attributes

        attributes?.format = PixelFormat.RGBA_8888
        attributes?.width = 300
        attributes?.height = 300
        attributes?.alpha = 0.5f
        attributes?.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON

        w?.setAttributes(attributes)

        Log.i("Tag 重写textview onDraw", "重写textview")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val radius = 50f                //给定半径
        //给定圆心的的坐标
        val cx = 50f
        val cy = 50f
        val paint = Paint()       //实例化一个Paint对象
        paint.color = Color.BLUE      //设置圆的颜色
        //通过canvas的drawCircle方法画一个圆圈.
        canvas.drawCircle(cx, cy, radius, paint)
    }
}

