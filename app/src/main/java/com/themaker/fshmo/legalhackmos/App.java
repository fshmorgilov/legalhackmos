package com.themaker.fshmo.legalhackmos;

import android.app.Application;
import androidx.work.*;
import com.facebook.stetho.Stetho;

public class App extends Application {

    private static App APP_INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();
        APP_INSTANCE = this;
        Stetho.initializeWithDefaults(this);
//        performScheduledWork();
    }

    private static void performScheduledWork() {
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
//        PeriodicWorkRequest workRequest = new PeriodicWorkRequest.Builder(
//                RevisionRequestService.class,
//                RevisionRequestService.REQUEST_INTERVAL,
//                TimeUnit.HOURS)
//                .addTag(RevisionRequestService.WORK_TAG)
//                .setBackoffCriteria(BackoffPolicy.EXPONENTIAL, 2, TimeUnit.HOURS)
//                .setConstraints(constraints)
//                .build();
//        NetworkUtils.getInstance()
//                .getNotificationTapReceiver()
//                .setWorkRequestId(workRequest.getId());
//        WorkManager.getInstance()
//                .enqueueUniquePeriodicWork(RevisionRequestService.WORK_TAG, ExistingPeriodicWorkPolicy.KEEP, workRequest);
    }

    public static App getInstance() {
        return APP_INSTANCE;
    }


}
