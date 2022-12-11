package com.merhaba.telefon_rehberi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataAccessHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "Contacts.db";
    public static int DATABASE_VERSION = 1;
    private Context context;

    public DataAccessHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE CONTACTS (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " NAME TEXT NOT NULL, NUMBER TEXT NOT NULL, MAIL TEXT );" );
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVers, int newVers){
        db.execSQL("DROP TABLE IF EXISTS CONTACTS");
        onCreate(db);
    }
}
