package com.adrianconstantin.mathtrainer.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by AdrianConstantin on 12/1/2015.
 */
public class NotificationBootReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, ScheduledAlarmService.class));
    }
}
