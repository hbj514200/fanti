package com.qq.qzone.a1336892373.fantai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import net.youmi.android.AdManager;

public class welcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tiaozhuan();
        AdManager.getInstance(welcomeActivity.this).init("f7d0a530280e2100", "194a307243eb6ae2", true, true);
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
