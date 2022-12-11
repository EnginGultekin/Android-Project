package com.engleg.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(MainActivity.this , "Toast Message", Toast.LENGTH_LONG).show();
        // Bu satırda uygulama açılır açılmaz ekranda kısa süre görünen ve kaybolan bir mesaj(popap) olusturduk.

    }


    public void save(View view){
        //Save butonuna bastığımızda bize aşağıdakki "Are you sure for Save" uyarı mesajını verecektir
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Save");
        alert.setMessage("Are you sure for Save");
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {  // Yes dersek olacaklar
            @Override
            public void onClick(DialogInterface dialog, int which) {
            //Save
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
                // Yes'e tıklayınca ekranda "Saved" yazılı bir popap göreceğiz.
            }
        });

        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            //Don't  Save
                Toast.makeText(MainActivity.this, "Not Saved", Toast.LENGTH_LONG).show();
                // No'ya tıklayınca ekranda "Not Saved" yazılı bir popap gelecek.
            }
        });

        alert.show();
    }
}