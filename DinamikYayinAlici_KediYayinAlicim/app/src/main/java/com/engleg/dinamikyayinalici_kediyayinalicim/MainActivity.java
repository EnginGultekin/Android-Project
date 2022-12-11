package com.engleg.dinamikyayinalici_kediyayinalicim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private BroadcastReceiver ozelyayinalicim = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i("Özel Yayın Alıcım","Yayın ALındı");
        }
    };

    public static final String YAYIN_ADI = "net.merhabaandroid.yayin_adi";
    Button yayingonderici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        yayingonderici = findViewById(R.id.yayinGonderici);
        yayingonderici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(YAYIN_ADI);
                sendBroadcast(intent);
            }
        });
        IntentFilter ozelfiltrem = new IntentFilter(YAYIN_ADI);
        registerReceiver( ozelyayinalicim , ozelfiltrem);
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(ozelyayinalicim);
        super.onDestroy();
    }
}