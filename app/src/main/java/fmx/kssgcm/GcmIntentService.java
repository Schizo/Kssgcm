package fmx.kssgcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fmx on 31.03.15.
 */
public class GcmIntentService extends IntentService {


    public static final int NOTIFICATION_ID = 1;

    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (extras != null && !extras.isEmpty()) {  // has effect of unparcelling Bundle
            // Since we're not using two way messaging, this is all we really to check for
            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Logger.getLogger("GCM_RECEIVED").log(Level.INFO, extras.toString());

                showToast(extras.getString("message"));


                NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setSmallIcon(R.drawable.abc_btn_radio_material);

                // Set the intent that will fire when the user taps the notification.
              //  builder.setContentIntent(pendingIntent);

                // Set the notification to auto-cancel. This means that the notification will disappear
                // after the user taps it, rather than remaining until it's explicitly dismissed.
                builder.setAutoCancel(true);
                builder.setContentTitle("Jagon Production");
                builder.setContentText(extras.getString("message"));
                builder.setSubText("Tap to view documentation about notifications.");
                NotificationManager notificationManager = (NotificationManager) getSystemService(
                        NOTIFICATION_SERVICE);
                notificationManager.notify(NOTIFICATION_ID, builder.build());

            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    protected void showToast(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}