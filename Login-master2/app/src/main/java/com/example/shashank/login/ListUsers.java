package com.example.shashank.login;

import android.database.Cursor;

import android.os.Bundle;
import android.widget.TextView;

public class ListUsers extends MainActivity {


   // TextView bilgiler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);



        // bilgiler=(TextView)findViewById(R.id.textViewbilgiler);
        //bilgiler.setMovementMethod(new ScrollingMovementMethod());

        Cursor cursor = kayitgetir();
        kayitgoster(cursor);


    }


}