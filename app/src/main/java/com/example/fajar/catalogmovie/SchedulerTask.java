package com.example.fajar.catalogmovie;

import android.content.Context;

import com.google.android.gms.gcm.GcmNetworkManager;
import com.google.android.gms.gcm.PeriodicTask;
import com.google.android.gms.gcm.Task;



public class SchedulerTask {
    private GcmNetworkManager mGcmNetworkManager;
    public SchedulerTask(Context context){
        mGcmNetworkManager = GcmNetworkManager.getInstance(context);
    }

    public void createPeriodTask(){
        Task task = new  PeriodicTask.Builder()
                .setService(SchedulerService.class)
                .setPeriod(60)
                .setFlex(10)
                .setTag(SchedulerService.TAG_TASK_MOVIE)
                .setPersisted(true)
                .build();
        mGcmNetworkManager.schedule(task);
    }
}
