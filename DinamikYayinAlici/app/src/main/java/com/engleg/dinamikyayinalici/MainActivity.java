package com.engleg.dinamikyayinalici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver zamanDinleyicim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        zamanDinleyicim = new ZamanDinleyici();
        IntentFilter filter = new IntentFilter(Intent.ACTION_TIME_CHANGED);
        registerReceiver(zamanDinleyicim ,filter);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(zamanDinleyicim);
        super.onDestroy();
    }
}