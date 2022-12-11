package com.engleg.catchthefoto;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView timeText;       // Burda Sadece Tanımlamaları Yaptık
    TextView scoreText;
    ImageView imageView1;
    ImageView imageView2;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;

    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.timeText);          // Burdada İnitilization yaptık
        timeText.setText("Time : 10");
        scoreText = findViewById(R.id.scoreText);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageView6 = findViewById(R.id.imageView6);
        imageView7 = findViewById(R.id.imageView7);
        imageView8 = findViewById(R.id.imageView8);
        imageView9 = findViewById(R.id.imageView9);

        //Tüm resimleri tek bir array içinde topladık
        imageArray = new ImageView[] {imageView1,imageView2,imageView3,imageView4,imageView5,
                imageView6,imageView7,imageView8,imageView9};

        hideImage();   // tüm resimleri gizlerken tek bir resimi görünür yapan fonksyon

        new CountDownTimer(10000,1000){    // Time'ı Azaltan
            @Override
            public void onTick(long millisUntilFinished) {
                timeText.setText("Time : " + millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {             // Time=0 olunca yapılacaklar
                timeText.setText("Time is Out");
                handler.removeCallbacks(runnable);
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);   // Oyun bitince hepsini yeniden görünmez yaptık
                }
                // Oyun süresi bitince bize uyarı meajı verip yeniden oynamak istediğimizi sorduk
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("Restar ?");
                alert.setMessage("Are You Sure For Restar The Game");
                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this , "Gamer Exit",Toast.LENGTH_LONG).show();
                    }
                });
                alert.show();
            }
        }.start();
    }

    public void increaseScore(View view){       // Resme her tıkladığımızda Score'u bir arttırdık
        score++;
        scoreText.setText("Score : " + score);
    }

    public void hideImage(){       // Burasıda resimleri gizleyip tek bir yeri açık gözterdiğimiz kısım
        handler = new Handler();

        runnable = new Runnable(){

            @Override
            public void run() {
                for(ImageView image : imageArray){
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);

                handler.postDelayed(this,350);    // ne kadar sürede yer değiştirdiği
            }
        };

        handler.post(runnable);
    }
}