package ca.zgrs.clipper;

import android.text.ClipboardManager;
import android.app.IntentService;
import android.content.Intent;

import android.util.Log;

import ca.zgrs.clipper.Clipper;

public class ClipboardService extends IntentService {
	private static String TAG = "Clipboard service";


	public ClipboardService() {
		super("ClipboardService"); 
	}

	/**
	* The IntentService calls this method from the default worker thread with
	* the intent that started the service. When this method returns, IntentService
	* stops the service, as appropriate.
	*/
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d(TAG, "Inside intent handler!");
		Log.d(TAG, String.format("Action: %s, Text: %s", intent.getAction(), intent.getStringExtra(Clipper.EXTRA_TEXT)));
		
		ClipboardManager cb = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		if (Clipper.isActionSet(intent.getAction())) {
			Log.d(TAG, "Setting text into clipboard");
			cb.setText( intent.getStringExtra(Clipper.EXTRA_TEXT));
		} else if (Clipper.isActionGet( intent.getAction()) ) {
			Log.d(TAG, "Getting text from clipboard");
			String clip  = cb.getText().toString();
			Log.i(TAG, "Clipboard text:"+clip);
		}
	}
}