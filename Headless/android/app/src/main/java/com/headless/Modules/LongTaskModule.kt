package com.headless.Modules

import android.content.Context
import android.graphics.PixelFormat
import android.util.Log
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import bolts.Task.delay
import com.facebook.react.bridge.Callback

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.headless.views.BallView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import android.view.WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY
import android.widget.TextView
import com.headless.R


class LongTaskModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {
    val context = reactContext

    override fun getName(): String {
        return "LongTask"
    }

    @ReactMethod
    fun run(callback: Callback) {
        //Thread.sleep(5000)
        var num = 0
        for(index in 0..500000000) {
            num += index
        }
        Log.i("Tag Thread", Thread.currentThread().name)
        callback(Thread.currentThread().name)
    }

    @ReactMethod
    fun runAsync(callback: Callback) {
        GlobalScope.launch { // 在一个公共线程池中创建一个协程
//            delay(5000) // 非阻塞的延迟一秒（默认单位是毫秒）

            var num = 0
            for(index in 0..500000000) {
                num += index
            }
            println("World!") // 在延迟后进行打印
            Log.i("Tag Thread", num.toString())
            callback(num)
        }

    }

    @ReactMethod
    fun floatWindow() {
//        val mWindowManager = reactApplicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
//        Log.i("applicationContext", this.currentActivity.toString())
//        val ballView = TextView(context)
//        Log.i("applicationContext111", mWindowManager.getDefaultDisplay().toString())
//
//
//        val p = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)
//        ballView.layoutParams = p
//        ballView.text = "women"
//
//        val window = this.currentActivity?.getWindow()?.layoutInflater?.inflate(R.layout.layout_1, null)
//        val name = this.currentActivity?.packageName
//
//        Log.i("ball123", name.toString())
//        Log.i("ball1234", this.currentActivity.toString())
//
//
//        val params = WindowManager.LayoutParams(
//                WindowManager.LayoutParams.TYPE_BASE_APPLICATION,
//                WindowManager.LayoutParams.MATCH_PARENT,
//                WindowManager.LayoutParams.MATCH_PARENT)
//
//        params.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
//        mWindowManager.addView(window, params)

//        val w = this.currentActivity?.getWindow()
//        val attributes = w?.attributes
//        attributes?.width = 300
//        attributes?.height = 300
//        attributes?.alpha = 0.5f
//
//        w?.setAttributes(attributes)
//        Log.i("ball123", attributes.toString())

    }
}