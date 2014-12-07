package ca.zgrs.clipper;

import android.app.Activity;
import android.text.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;

import android.util.Log;

/*
 * Receives broadcast commands and controls clipboard accordingly.
 * The broadcast receiver is active only as long as the application, or its service is active.
 */
public class ClipperReceiver extends BroadcastReceiver {
	private static String TAG = "ClipboardReceiver";

    public static String ACTION_GET = "clipper.get";
    public static String ACTION_GET_SHORT = "get";
    public static String ACTION_SET = "clipper.set";
    public static String ACTION_SET_SHORT = "set";

    public static String EXTRA_TEXT = "text";

    public static boolean isActionGet(final String action) {
        return ACTION_GET.equals(action) || ACTION_GET_SHORT.equals(action);
    }

    public static boolean isActionSet(final String action) {
        return ACTION_SET.equals(action) || ACTION_SET_SHORT.equals(action);
    }

	
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "Inside broadcast handler!");

        Log.d(TAG, String.format("Action: %s", intent.getAction()));

        ClipboardManager cb = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (isActionSet(intent.getAction())) {
            Log.d(TAG, "Setting text into clipboard");
            String text = intent.getStringExtra(EXTRA_TEXT);
            if (text != null) {
                cb.setText(text);
                setResultCode(Activity.RESULT_OK);
                setResultData("Text is copied in clipboard.");
            } else {
                setResultCode(Activity.RESULT_CANCELED);
                setResultData("No text was provided. Use -e text \"text to be pasted\"");
            }
        } else if (isActionGet(intent.getAction())) {
            Log.d(TAG, "Getting text from clipboard");
            CharSequence clip  = cb.getText();
            if (clip != null) {
                Log.d(TAG, String.format(" dd Clipboard text: %s", clip));
                setResultCode(Activity.RESULT_OK);
                setResultData(clip.toString());
            } else {
                setResultCode(Activity.RESULT_CANCELED);
                setResultData("Clipboard is empty.");
            }
		}
    }
    //android.intent.action.PACKAGE_ADDED

}