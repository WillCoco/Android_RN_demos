package com.floatwindow.Modules

import android.content.Context
import android.graphics.PixelFormat
import android.util.Log
import android.view.*
import android.widget.TextView

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.views.view.ReactViewGroup
import com.floatwindow.R

class AddView(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "AddView"
    }

    @ReactMethod
    fun add() {
        val mWindowManager = this.currentActivity!!.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val ballView = TextView(this.currentActivity)

        val mView = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 100)
        val window = this.currentActivity?.getWindow()?.layoutInflater?.inflate(R.layout.float_window_layout, null)

        ballView.layoutParams = mView
        ballView.text = "women"

        val params = WindowManager.LayoutParams();
        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_ALERT
        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        params.format = PixelFormat.TRANSLUCENT
        params.gravity = Gravity.CENTER
        params.width = 300
        params.height = 300

        mWindowManager.addView(window, params)

        Log.i("agsdjkh", "111")
    }

    @ReactMethod
    fun remove(name: String) {

    }
}
