package com.qq.qzone.a1336892373.fantai;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button jButton;
    private Button fButton;
    InterstitialAd mInterstitialAd;
    private EditText editText;
    private ImageView yuanbutton;
    private int yuanflag = 1;
    private int adflag = 0;
    Handler myhandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            adflag = 1;
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jButton = (Button) findViewById(R.id.jbutton);
        fButton = (Button) findViewById(R.id.fbutton);
        editText = (EditText) findViewById(R.id.edittext);
        yuanbutton = (ImageView) findViewById(R.id.yuanbutton);

        jButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        yuanbutton.setOnClickListener(this);
        admob();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(10000); } catch (Exception e) { }
                myhandler.sendMessage( new Message() );
                try { Thread.sleep(200000); } catch (Exception e) { }
                myhandler.sendMessage( new Message() );
                try { Thread.sleep(200000); } catch (Exception e) { }
                myhandler.sendMessage( new Message() );
                try { Thread.sleep(200000); } catch (Exception e) { }
                myhandler.sendMessage( new Message() );
            }
        }).start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jbutton:
                editText.setText(tools.tofanti(editText.getText().toString()));
                zhanshi();
                break;
            case R.id.fbutton:
                editText.setText(tools.tojianti(editText.getText().toString()));
                zhanshi();
                break;
            case R.id.yuanbutton:
                zhanshi();
                if (yuanflag % 2 == 1) {
                    yuanbutton.setImageResource(R.drawable.yuanbutton2);
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    editText.setText(cm.getText());
                    cm.setText("");
                } else {
                    yuanbutton.setImageResource(R.drawable.yuanbutton);
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.yijin), Toast.LENGTH_SHORT).show();
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    cm.setText(editText.getText().toString());
                    editText.setText("");
                }
                yuanflag++;
                break;
            default:
                break;
        }
    }

    private void zhanshi(){
        if (adflag==1 && mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
            adflag = 0;
        }
    }
    private void admob(){
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6630898560544189/3871700555");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
            }
        });
        requestNewInterstitial();
    }
    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();
        mInterstitialAd.loadAd(adRequest);
    }

}
