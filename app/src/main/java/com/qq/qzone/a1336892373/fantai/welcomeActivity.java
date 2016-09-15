package com.qq.qzone.a1336892373.fantai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

public class welcomeActivity extends Activity {

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tiaozhuan();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(welcomeActivity.this);
    }

    private void tiaozhuan(){
        new Thread(new Runnable() {
            @Override
            public void run() {
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

}
