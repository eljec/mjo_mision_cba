package aplication.mjo.misioncba.com.mjomisioncbaapp.Notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import aplication.mjo.misioncba.com.mjomisioncbaapp.R;
import aplication.mjo.misioncba.com.mjomisioncbaapp.SplashActivity;

/**
 * Created by jucastillo on 3/1/18.
 */

public class MisionMjoFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM Service";

    private int notify_no= 0;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage)
    {
        sendNotification(remoteMessage.getNotification().getBody(), getString(R.string.app_name));
    }


    private void sendNotification(String messageBody, String title) {
        Intent intent = new Intent(this, SplashActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, notify_no /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);
        if (notify_no < 9) {
            notify_no = notify_no + 1;
        } else {
            notify_no = 0;
        }
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_notification_icon)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notify_no + 2 /* ID of notification */, notificationBuilder.build());
    }
}
