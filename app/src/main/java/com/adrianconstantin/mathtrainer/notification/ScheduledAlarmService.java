package com.adrianconstantin.mathtrainer.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.adrianconstantin.mathtrainer.setting.OperationSettings;

import java.util.Calendar;

/**
 * Created by AdrianConstantin on 12/2/2015.
 */
public class ScheduledAlarmService extends Service {

    /**
     *
     */
    public static void CreateAlarm(Context context, Class<?> cls){
        if (!OperationSettings.Instance().GetIsNotificationEnabled()) return;

        CancelAlarm(context, cls);

        Intent alarmIntent = new Intent(context, cls);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, OperationSettings.Instance().GetHour());
        calendar.set(Calendar.MINUTE, OperationSettings.Instance().GetMinute());
        calendar.set(Calendar.SECOND, 0);

        int oneDayMillis = 24 * 60 * 60 * 1000;
        if (calendar.getTimeInMillis() < System.currentTimeMillis()) {
            calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);
        }

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), oneDayMillis, pendingIntent);
    }

    /**
     *
     * @param context
     */
    public static void CancelAlarm(Context context, Class<?> cls)
    {
        Intent intent = new Intent(context, cls);
        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(sender);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        OperationSettings.Instance().LoadOptions(this);
        CreateAlarm(this, NotificationServiceReceiver.class);
    }

    /**
     * Return the communication channel to the service.  May return null if
     * clients can not bind to the service.  The returned
     * {@link IBinder} is usually for a complex interface
     * that has been <a href="{@docRoot}guide/components/aidl.html">described using
     * aidl</a>.
     * <p/>
     * <p><em>Note that unlike other application components, calls on to the
     * IBinder interface returned here may not happen on the main thread
     * of the process</em>.  More information about the main thread can be found in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
     * Threads</a>.</p>
     *
     * @param intent The Intent that was used to bind to this service,
     *               as given to {@link Context#bindService
     *               Context.bindService}.  Note that any extras that were included with
     *               the Intent at that point will <em>not</em> be seen here.
     * @return Return an IBinder through which clients can call on to the
     * service.
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
