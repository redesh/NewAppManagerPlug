package com.peter.managerplug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class RestartReceiver extends BroadcastReceiver {

	public static final String TARGET_PACKAGE_NAME = "com.peter.appmanager";
	public static final String TARGET_ACTION = "com.peter.appmanager";
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Uri url = intent.getData();
		String str = url.toString();
		String[] infos = str.split(":");
		for(String info : infos) {
			if(info.equals(TARGET_PACKAGE_NAME)) {
				Toast.makeText(context, "YinService RestartReceiver", Toast.LENGTH_SHORT).show();
				context.startService(new Intent(TARGET_ACTION));
			}
		}
	}

}
