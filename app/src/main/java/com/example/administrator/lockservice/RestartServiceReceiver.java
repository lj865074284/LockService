package com.example.administrator.lockservice;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * @author 李宗好
 * @desc 被通知启动所有核心服务
 */
public class RestartServiceReceiver extends BroadcastReceiver {

    public static final String RESTART_SERVICE_ACTION = RestartServiceReceiver.class.getCanonicalName();

    public RestartServiceReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (RESTART_SERVICE_ACTION.equals(action)) {
            Class<Service> clazz = (Class<Service>) intent.getSerializableExtra("clazz");
            DefendManager.getInstance().startService(context, clazz);
        }
    }
}
