package com.mahindra.kmsga.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.akshay.reminder.R


fun isNetworkConnected(context: Context): Boolean {

    return try {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo

        if (activeNetworkInfo != null && activeNetworkInfo.isConnected)
            true
        else {
            Toast.makeText(context, context.getString(R.string.internet_error), Toast.LENGTH_SHORT).show()
            false
        }

    } catch (e: Exception) {
        true
    }

}
