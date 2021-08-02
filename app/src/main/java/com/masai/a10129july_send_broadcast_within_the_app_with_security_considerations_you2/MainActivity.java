package com.masai.a10129july_send_broadcast_within_the_app_with_security_considerations_you2;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button mBtnGetData;
    SimpleBroadCast simpleBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Debug1", "onCreate1");
        initViews();
        buttonClicked();
    }

    private void buttonClicked() {
        mBtnGetData.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setAction("com.Lloyd.com");
            intent.putExtra("abc", "Landed On Second Activity");
            sendBroadcast(intent);
            registeredBroadcast();
        });
    }

    private void initViews() {
        mBtnGetData = findViewById(R.id.btn1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent("com.Lloyd.com");
        intent.putExtra("abc", "Landed On Second Activity");
        sendBroadcast(intent, Manifest.permission.CAMERA);
    }

    private void registeredBroadcast() {
        simpleBroadCastReceiver = new SimpleBroadCast();
        IntentFilter intentFilter = new IntentFilter("com.Lloyd.com");
        registerReceiver(simpleBroadCastReceiver, intentFilter);
    }
}