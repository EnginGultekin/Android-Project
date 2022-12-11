package com.engleg.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.database.Cursor;

// import com.engleg.login.SQLiteHelper;

public class ListUsers extends  MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);


        Cursor cursor = kayitgetir();
        kayitgoster(cursor);


    }
}