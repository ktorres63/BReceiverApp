package com.tutorial.notificationsapp

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmNotification: BroadcastReceiver() {
    companion object {
        const val NOTIFICATION_ID = 1
    }
    override fun onReceive(context: Context, intent: Intent?) {
        createSimpleNotification(context)
    }

    private fun createSimpleNotification(context: Context) {
        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val flag = if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0

        val pendingIntent: PendingIntent = PendingIntent.getActivity(context,0,intent,flag)

        val notification = NotificationCompat.Builder(context, MainActivity.MY_CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_delete)
            .setContentTitle("My title")
            .setContentText("Exxto es es un ejemplo :)")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam volutpat a elit id porttitor. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Quisque tincidunt neque ut malesuada elementum. Nunc vitae erat neque. Praesent ullamcorper pulvinar pharetra. Donec ac accumsan tellus. Duis vestibulum pharetra justo, ultricies volutpat felis mattis")
            )
            .setContentIntent(pendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1,notification)



    }
}















