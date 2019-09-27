package com.akshay.reminder._utilities

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }
}