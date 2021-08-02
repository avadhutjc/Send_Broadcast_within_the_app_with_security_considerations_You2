package com.masai.a10129july_send_broadcast_within_the_app_with_security_considerations_you2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class SimpleBroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            Intent activityIntent = new Intent(context, SecondActivity.class);
            String message = intent.getStringExtra("Landed On Second Activity");
            activityIntent.putExtra("abc", message);
            context.startActivity(activityIntent);
        }
    }
}
