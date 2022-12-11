package com.engleg.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{
            // Alt satırda "Musicians" adında bir veritabanı oluşturduk
            SQLiteDatabase database= this.openOrCreateDatabase("Musicians",MODE_PRIVATE,null);
            //Burda "musicians" adında bir tablo oluşturduuk ve iki attribute verdik
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians(id INTEGER PRIMARY KEY,name VARCHAR,age INT)");

            // ----DİKKAT---- Burdakileri veritabanına yazdık ve o yüzden yorum satırına aldık
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('EngLend',72)");
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('Ykop',20)");
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('Demet',22)");
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('Sil',15)");

            //Güncelleme Satırları
            //database.execSQL("UPDATE musicians SET age=22 WHERE name = 'EngLend'");
            //database.execSQL("UPDATE musicians SET name = 'Demet Edgar Poe' WHERE id = 3");

            //Silme Satırları
            //database.execSQL("DELETE FROM musicians WHERE age = 15");

            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'Demet'",null);
            Cursor cursor = database.rawQuery("SELECT * FROM musicians",null);

            int nameIx = cursor.getColumnIndex("name");
            int ageIx  = cursor.getColumnIndex("age");
            int idIx   = cursor.getColumnIndex("id");

            while(cursor.moveToNext()){
                System.out.println("Name : " + cursor.getString(nameIx));
                System.out.println("Age : "  + cursor.getInt(ageIx));
                System.out.println("ID : " + cursor.getInt(idIx));
            }
            cursor.close();

        }catch (Exception e){
           e.printStackTrace();
        }
    }
}