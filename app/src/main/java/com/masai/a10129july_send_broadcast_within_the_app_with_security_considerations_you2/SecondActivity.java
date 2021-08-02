package com.masai.a10129july_send_broadcast_within_the_app_with_security_considerations_you2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private TextView mTv1;
    private SimpleBroadCast simpleBroadCast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d("Debug2", "onCreate2");

        mTv1 = findViewById(R.id.tv1);
        String message = getIntent().getStringExtra("Landed On Second Activity");
        mTv1.setText(message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(simpleBroadCast);
    }
}