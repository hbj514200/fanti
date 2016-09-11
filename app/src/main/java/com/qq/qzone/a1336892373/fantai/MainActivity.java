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

public class MainActivity extends Activity implements View.OnClickListener{

    private Button jButton;
    private Button fButton;
    private EditText editText;
    private ImageView yuanbutton;
    private int yuanflag = 1;

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
                }
                else{
                    yuanbutton.setImageResource(R.drawable.yuanbutton);
                    Toast.makeText(MainActivity.this, "已经复制到剪切板", Toast.LENGTH_SHORT).show();
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    cm.setText(editText.getText().toString());
                }
                yuanflag++;
                break;
            default:
                break;
        }
    }

}
