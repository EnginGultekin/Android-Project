package com.kizilkaya.androidproje;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CommentsActivity extends AppCompatActivity {

    EditText yorum;
    RatingBar ratingBar;
    TextView sonuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        yorum = findViewById(R.id.yorumyap);
        addListenerOnRatingBar();
    }


    public void addListenerOnRatingBar() {

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        sonuc = (TextView) findViewById(R.id.sonuc);

        //if rating value is changed,
        //display the current rating value in the result (textview) automatically
        ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                sonuc.setText(String.valueOf(rating));
            }
        });
    }



    public void onay(View view){
        if(yorum.getText().toString().trim().equals("")){
            Toast.makeText(CommentsActivity.this, "Yorum Yapmadınız", Toast.LENGTH_LONG).show();
        }
        else{
            AlertDialog.Builder alert = new AlertDialog.Builder(this);

            alert.setTitle("Gönder");
            alert.setMessage("Yorumu Göndermeye Emin misin ?");
            alert.setPositiveButton("EVET", new DialogInterface.OnClickListener() {  // Yes dersek olacaklar
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //onay
                    Toast.makeText(CommentsActivity.this, "Yorumunuz Gönderildi", Toast.LENGTH_LONG).show();
                    yorum.getText().clear();
                    // Yes'e tıklayınca ekranda "Saved" yazılı bir popap göreceğiz.
                }
            });

            alert.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Don't  Save
                    Toast.makeText(CommentsActivity.this, "Yorumunuz Gönderilmedi", Toast.LENGTH_LONG).show();
                    // No'ya tıklayınca ekranda "Not Saved" yazılı bir popap gelecek.
                }
            });

            alert.show();
        }

    }


    public void geridon(View view){
        Intent intent = new Intent(CommentsActivity.this, RMainActivity.class);
        startActivity(intent);
    }

}