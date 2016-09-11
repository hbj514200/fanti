package com.qq.qzone.a1336892373.fantai;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import net.youmi.android.normal.spot.SpotManager;

public class MainActivity extends Activity implements View.OnClickListener{

    private Button jButton;
    private Button fButton;
    private EditText editText;
    private ImageView yuanbutton;
    private int yuanflag = 1;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jButton = (Button) findViewById(R.id.jbutton);
        fButton = (Button) findViewById(R.id.fbutton);
        editText = (EditText) findViewById(R.id.edittext);
        yuanbutton=  (ImageView) findViewById(R.id.yuanbutton);

        jButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        yuanbutton.setOnClickListener(this);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try { Thread.sleep(45000); } catch (Exception e) { }
                SpotManager.getInstance(MainActivity.this).setSpotOrientation(SpotManager.ORIENTATION_PORTRAIT);
                SpotManager.getInstance(MainActivity.this).setAnimationType(SpotManager.ANIM_SIMPLE);
                SpotManager.getInstance(MainActivity.this).showSpotAds(MainActivity.this);
            }
        }).start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.jbutton :
                editText.setText(tools.tofanti(editText.getText().toString()));
                break;
            case R.id.fbutton :
                editText.setText(tools.tojianti(editText.getText().toString()));
                break;
            case R.id.yuanbutton :
                if (yuanflag%2==1){
                    yuanbutton.setImageResource(R.drawable.yuanbutton2);
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    editText.setText(cm.getText());
                    cm.setText("");
                }
                else{
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

}
