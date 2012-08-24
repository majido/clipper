package ca.zgrs.clipper;

import android.text.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

import android.util.Log;

import ca.zgrs.clipper.Clipper;
/* Same implementatio just listen to broadcasts */
public class ClipperReceiver extends BroadcastReceiver {
	private static String TAG = "Clipboard receiver";
		
	
    @Override
    public void onReceive(Context context, Intent intent) {
	
		  Log.d(TAG, "Inside broadcast handler!");
		  Log.d(TAG, String.format("Action: %s, Text: %s", intent.getAction(), intent.getStringExtra(Clipper.EXTRA_TEXT)));

		  ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
		  if (Clipper.isActionSet(intent.getAction())) {
		  		Log.d(TAG, "Setting text into clipboard");
		  		cb.setText(intent.getStringExtra(Clipper.EXTRA_TEXT));
				setResultCode(1);
		        setResultData("Success!");
		   } else if (Clipper.isActionGet( intent.getAction()) ) {
		  		Log.d(TAG, "Getting text from clipboard");
				String clip  = cb.getText().toString();
				Log.d(TAG, String.format(" dd Clipboard text: %s",clip));
				setResultCode(1);
				setResultData(clip);
		   }
		
    }

}