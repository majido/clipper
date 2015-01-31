package ca.zgrs.clipper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class Main extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        // start clipboard service
        Intent serviceIntent = new Intent(this, ClipboardService.class);
        startService(serviceIntent);
    }
}