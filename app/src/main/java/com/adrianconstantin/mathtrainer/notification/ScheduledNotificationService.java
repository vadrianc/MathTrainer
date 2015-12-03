package com.adrianconstantin.mathtrainer.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

import com.adrianconstantin.mathtrainer.R;
import com.adrianconstantin.mathtrainer.activity.MainMathTrainer;
import com.adrianconstantin.mathtrainer.utils.Utils;

public class ScheduledNotificationService extends Service {

    /**
     *
     * @param context
     */
    public static void CreateNotification(Context context){
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle(Utils.NOTIFICATION_TITLE_TEXT)
                        .setContentText(Utils.NOTIFICATION_CONTENT_TEXT)
                        .setSound(alarmSound)
                        .setAutoCancel(true);
        Intent resultIntent = new Intent(context, MainMathTrainer.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addParentStack(MainMathTrainer.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CreateNotification(this);
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