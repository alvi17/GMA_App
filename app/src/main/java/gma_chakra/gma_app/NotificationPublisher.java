package gma_chakra.gma_app;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Alvi17 on 10/20/2015.
 */
public class NotificationPublisher extends BroadcastReceiver {

    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";

    public void onReceive(Context context, Intent intent) {

        NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = intent.getParcelableExtra(NOTIFICATION);
        int id = intent.getIntExtra(NOTIFICATION_ID, 0);
        int on_off=intent.getIntExtra("On_Off",0);
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        Intent notificationIntent = new Intent(context, MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent intent1 = PendingIntent.getActivity(context, 0,
                notificationIntent, 0);
        notification.contentIntent = intent1;

        if(on_off==0)
        {
            notificationManager.cancel(id);
        }
        else
            notificationManager.notify(id, notification);
    //    Intent intent1 = new Intent(context, MainActivity.class);
     //   context.startActivity(intent1);
      //  PendingIntent pIntent = PendingIntent.getActivity(getAbo, 0, intent1, 0);

    }
}