package com.qq.qzone.a1336892373.fantai;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class welcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tiaozhuan();
    }

    private void tiaozhuan(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
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
