package com.cm.android;

import android.text.ClipboardManager;
import android.app.IntentService;
import android.content.Intent;

import android.util.Log;

public class ClipboardServiceFront extends IntentService {
	private static String TAG = "Clipboard service";
	
	
	
	 private static String ACTION_GET = "get";
	 private static String ACTION_SET = "set";
	
	 private static String EXTRA_TEXT = "text";
	
	
	 
  /** 
   * A constructor is required, and must call the super IntentService(String)
   * constructor with a name for the worker thread.
   */
  public ClipboardServiceFront() {
      super("ClipboardServiceFront");
	  
  }

  /**
   * The IntentService calls this method from the default worker thread with
   * the intent that started the service. When this method returns, IntentService
   * stops the service, as appropriate.
   */
  @Override
  protected void onHandleIntent(Intent intent) {
	  Log.i(TAG, "Inside intent handler!");
	  Log.i(TAG, "ACTION:"+intent.getAction());
	  Log.i(TAG, "Text:"+ intent.getStringExtra(EXTRA_TEXT));
	
	  ClipboardManager cb = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
	  if (ACTION_SET.equals(intent.getAction())) {
	  		Log.i(TAG, "Setting text into clipboard");
	  		cb.setText( intent.getStringExtra(EXTRA_TEXT));
	   } else if (ACTION_GET.equals( intent.getAction()) ) {
	  		String clip  = cb.getText().toString();
			Log.i(TAG, "Got this from clipboard:"+clip);
	   	   	
	   }
  }
}