package com.adrianconstantin.mathtrainer.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationServiceReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ScheduledNotificationService.class));
    }
}