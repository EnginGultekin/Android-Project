package com.merhaba.telefon_rehberi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.widget.Toast;

public class DataAccess {

    private SQLiteDatabase db;
    private final Context context;
    private final DataAccessHelper dbHelper;

    public static String CONTACTID_COLUMN = "_id";
    public static String CONTACTNAME_COLUMN = "NAME";
    public static String CONTACTNUMBER_COLUMN = "NUMBER";
    public static String CONTACTMAIL_COLUMN = "MAIL";
    public static String TABLE_NAME = "CONTACTS";

    public DataAccess(Context c){
        context = c;
        dbHelper = new DataAccessHelper(context);
    }
    public void closeDatabase(){
        db.close();
    }

    public void connectToDatabase() throws SQLiteException{
        try{
            db = dbHelper.getWritableDatabase();
        }
        catch (SQLiteException ex){
            db = dbHelper.getReadableDatabase();
        }
    }

    public void addContact(String name, String number, String mail){
            SQLiteDatabase db = this.dbHelper.getWritableDatabase();
            ContentValues newContentValue = new ContentValues();

            newContentValue.put(CONTACTNAME_COLUMN, name);
            newContentValue.put(CONTACTNUMBER_COLUMN, number);
            newContentValue.put(CONTACTMAIL_COLUMN, mail);

            long result = db.insert(TABLE_NAME, null, newContentValue);
        if (result == -1){
            Toast.makeText(context, "Hata!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Başarıyla Eklendi!", Toast.LENGTH_SHORT).show();
        }

    }


    public Cursor getAllContacts(){
        String querry = "SELECT * FROM " + TABLE_NAME + " ORDER BY NAME ASC";
        SQLiteDatabase db = this.dbHelper.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(querry, null);
        }
        return cursor;
    }

    public void updateContact(String row_id, String name, String number, String mail){
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(CONTACTNAME_COLUMN, name);
        cv.put(CONTACTNUMBER_COLUMN, number );
        cv.put(CONTACTMAIL_COLUMN, mail);
        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Hata!", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Başarıyla Güncellendi!", Toast.LENGTH_SHORT).show();
        }
    }


    public void deleteOneRow(String row_id){
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteAllData(){
        SQLiteDatabase db = this.dbHelper.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }

}
