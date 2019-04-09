package com.themaker.fshmo.legalhackmos.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.themaker.fshmo.legalhackmos.App;
import com.themaker.fshmo.legalhackmos.R;
import com.themaker.fshmo.legalhackmos.presentation.root.MainActivity;

import java.io.IOException;

import static com.themaker.fshmo.legalhackmos.service.NetworkUtils.NotificationTapReceiver.ACTION_TAP;

public class RevisionRequestService extends Worker {

    private static final String TAG = RevisionRequestService.class.getName();

    public static final String WORK_TAG = "Revision_request";
    private final Context context;

    private static final String channelId = "KlassikaplusChannel";
    private static final int notificationId = 123;
    public static final int REQUEST_INTERVAL = 24;//hours

    private NotificationManager notificationManager;



    public RevisionRequestService(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
//        try {
//            Integer serverRevision = api.revision().checkRevision().execute().body().getData();
//            if (serverRevision != null
//                    && !preferences.isFirstTimeAppLaunch()) {
//                if (serverRevision > preferences.getRevision()) {
//                    makeNotification();
//                    preferences.updateRevision(serverRevision);
//                }
//                if (serverRevision < preferences.getRevision()) {
//                    preferences.updateRevision(serverRevision);
//                }
//            }
//            return Result.success();
//        } catch (IOException e) {
//            Log.i(TAG, "doWork: call for API failed");
//            return Result.failure();
//        }
        return null;
    }

    private void makeNotification() {
        Intent notificationTapIntent = new Intent(context, MainActivity.class);
        notificationTapIntent.setAction(ACTION_TAP);
        notificationTapIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationTapIntent, 0);
        Notification notification = new NotificationCompat.Builder(getApplicationContext(), "abcde")
                .setSmallIcon(R.drawable.logo_main) // fixme: 2/20/2019 change icon
                .setContentTitle(context.getString(R.string.collection_is_updated))
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true)
                .build();
        if (notificationManager == null)
            notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        assert notificationManager != null;
        notificationManager.notify(notificationId, notification);
    }

    private void logError(Throwable throwable) {
        if (throwable instanceof IOException) {
            Log.e(TAG, "logError: " + throwable.getMessage());
        } else
            Log.e(TAG, "logError: stopped unexpectedly : \n" + throwable.getMessage());
    }
}