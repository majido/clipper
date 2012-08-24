package com.cm.android;

import android.text.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

import android.util.Log;
/* Same implementatio just listen to broadcasts */
public class ClipperReceiver extends BroadcastReceiver {
	private static String TAG = "Clipboard receiver";
	
	
	 private static String ACTION_GET = "get";
	 private static String ACTION_SET = "set";
	
	 private static String EXTRA_TEXT = "text";
	
    @Override
    public void onReceive(Context context, Intent intent) {
		  Log.i(TAG, "Inside intent handler!");
		  Log.i(TAG, "ACTION:"+ intent.getAction());
		  Log.i(TAG, "Text:"+ intent.getStringExtra(EXTRA_TEXT));

		  ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		
		  if (ACTION_SET.equals(intent.getAction())) {
		  		Log.i(TAG, "Setting text into clipboard");
		  		cb.setText( intent.getStringExtra(EXTRA_TEXT));
		   } else if (ACTION_GET.equals( intent.getAction()) ) {
		  		String clip  = cb.getText().toString();
				Log.i(TAG, "Got this from clipboard:" + clip);
		   }
		
    }

}