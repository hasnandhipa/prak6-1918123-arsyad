package com.example.pertemuan6_workmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {
    public MyWorker(@NonNull Context context, @NonNull
            WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        displayNotification("Notifikasi","Task kamu sudah selesai!");
        return Result.success();
    }

    public void displayNotification(String task, String desc){
        NotificationManager manager =
                (NotificationManager)
                        getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel = new
                NotificationChannel("Notif1",
                "Test1", NotificationManager.IMPORTANCE_HIGH);
        manager.createNotificationChannel(channel);

        NotificationCompat.Builder builder = new
                NotificationCompat.Builder(getApplicationContext(),
                "Notif1")
                .setContentTitle(task)
                .setContentText(desc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setPriority(NotificationCompat.PRIORITY_HIGH)

                .setCategory(NotificationCompat.CATEGORY_MESSAGE);

        manager.notify(1, builder.build());
    }
}
