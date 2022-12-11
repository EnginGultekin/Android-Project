package com.kizilkaya.androidproje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rmain);
    }
    public void toMenu(View view) {
        Intent intent = new Intent(RMainActivity.this, RMenuActivity.class);
        startActivity(intent);

    }
    public void toYorumlar(View view) {
        Intent intent = new Intent(RMainActivity.this ,CommentsActivity.class);
        startActivity(intent);
        Toast.makeText(this,"Yorumlar",Toast.LENGTH_LONG).show();

    }
    public void toKonum(View view) {
        Toast.makeText(this,"Konum",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RMainActivity.this ,GoogleMaps.class);
        startActivity(intent);

    }
    public void toFotograf(View view) {
        Toast.makeText(this,"Fotograf",Toast.LENGTH_LONG).show();

    }
    public void toMekanBilgisi(View view) {

        Toast.makeText(this,"Mekan Bilgisi",Toast.LENGTH_LONG).show();

    }
    public void toForum(View view) {
        Toast.makeText(this,"Forum",Toast.LENGTH_LONG).show();

    }

}