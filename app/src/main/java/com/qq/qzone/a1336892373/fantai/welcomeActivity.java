package com.qq.qzone.a1336892373.fantai;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import net.youmi.android.AdManager;

public class welcomeActivity extends Activity {

    Handler myhandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            AdManager.getInstance(welcomeActivity.this).init("f7d0a530280e2100", "194a307243eb6ae2", true, true);
            sendNotification();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tiaozhuan();
    }

    private void tiaozhuan(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(200); } catch (Exception e) { }
                myhandler.sendMessage(new Message());
                try {
                    Thread.sleep(1600);
                    startActivity(new Intent(welcomeActivity.this, MainActivity.class));
                    finish();
                } catch (Exception e){
                    startActivity(new Intent(welcomeActivity.this, MainActivity.class));
                    finish();
                }
            }
        }).start();
    }

    private void sendNotification() {
        Intent intent = new Intent(welcomeActivity.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(welcomeActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(welcomeActivity.this)
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle(getResources().getString(R.string.push_title))
                .setContentText(getResources().getString(R.string.push_content))
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }

}
