package ca.zgrs.clipper;

import android.app.IntentService;
import android.content.Intent;

import android.util.Log;

public class ClipboardService extends IntentService {
    private static String TAG = "ClipboardService";

    public ClipboardService() {
        super("ClipboardService");
    }

    /* Define service as sticky so that it stays in background */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // start itself to ensure our broadcast receiver is active
        Log.d(TAG, "Start clipboard service.");
        startService(new Intent(getApplicationContext(), ClipboardService.class));
    }

    /**
     * The IntentService calls this method from the default worker thread with
     * the intent that started the service. When this method returns, IntentService
     * stops the service, as appropriate.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
    }
}