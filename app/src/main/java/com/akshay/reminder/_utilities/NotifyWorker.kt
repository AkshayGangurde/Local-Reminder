package com.akshay.reminder._utilities

import android.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.akshay.reminder.MainActivity
import com.akshay.reminder._data.room.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*


class NotifyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        Log.d("doWork", "Start")
        val message = inputData.getString("Message")
        val uniqueID = inputData.getInt("ID", 0)
        triggerNotification(message, uniqueID)
        Log.d("doWork", "End")
        return Result.success()
    }

    /**
     * Method to trigger an instant notification
     */
    private fun triggerNotification(message: String?, uniqueID: Int) {

        val intent = Intent(applicationContext, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        intent.putExtra("ID", uniqueID)

        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, intent, 0)

        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            Objects.requireNonNull(notificationManager).createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, "default")
            .setContentTitle(message)
            .setContentIntent(pendingIntent)
            .setSmallIcon(R.mipmap.sym_def_app_icon)
            .setAutoCancel(true)

        Objects.requireNonNull(notificationManager).notify(uniqueID, notification.build())
        GlobalScope.launch {
            AppDatabase.getDatabase()?.getAppDao()?.updateMsgFlag(true, uniqueID)
        }
    }

}