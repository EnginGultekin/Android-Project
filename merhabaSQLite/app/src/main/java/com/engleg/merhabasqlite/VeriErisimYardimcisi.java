package com.engleg.merhabasqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeriErisimYardimcisi extends SQLiteOpenHelper {

    public static String VERITABANI_ADI = "Kitaplar.db";
    public  static int VERITABANI_VERSIYONU = 1;

    public VeriErisimYardimcisi(Context context){
        super(context ,VERITABANI_ADI,null,VERITABANI_VERSIYONU);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE KITAPLAR ("+"_id,INTEGER PRIMARY KEY AUTOINCREMENT,"+" " +
                "KITAPADI TEXT NOT NULL "+",YIL INTEGER NOT NULL);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS KITAPLAR");
        onCreate(db);
    }
}
