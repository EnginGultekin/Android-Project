package com.engleg.runnablehandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Runnable runnable;
    Handler handler;
    Button button;
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button1);
        number=0;
    }

    public void start(View view){
        handler = new Handler(Looper.getMainLooper());

        runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText(""+number);
                number++;
                textView.setText(""+number);
                handler.postDelayed(runnable, 1000);    // gecikme süresi
            }
        };
        handler.post(runnable);
        button.setEnabled(false);  // Starta bir kez bastığımızda bidaha basamamak için devre dışı bırakırız
    }
    public void stop(View view){
        button.setEnabled(true);    // Butonu aktif hale getiriyor

        handler.removeCallbacks(runnable);
        textView.setText(""+ number);
    }

    public void reset(View view){           // Resetbutonu
        //button.setEnabled(true);
        number = 0;
        textView.setText(""+number);
    }

}