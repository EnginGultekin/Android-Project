//package com.example.shashank.login;
//
//import android.os.Bundle;
//import android.content.Context;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.database.sqlite.SQLiteDatabase;
//import android.content.Intent;
//import android.database.Cursor;
//import android.support.v7.app.AppCompatActivity;
//
//import com.example.shashank.login.SQLiteHelper;
//
////Burayı UserListele Kısmına al
//
//public class Islemler {
//
//    SQLiteHelper benimDB;
//
//    public void Islemler(Context c){    // Cons.
//        benimDB = new SQLiteHelper(c);
//    }
//
//    SQLiteDatabase db;
//
//    public void ac(){
//        db = benimDB.getWritableDatabase();  // VeriTabanı aç
//    }
//
//    public void kapat(){
//        benimDB.close();
//    }
//
//
//    // İnsert Registerda yaptık zaten
//
//
//    // Verileri Çek
//
//    public void kullaniciOku(){
//        this.ac();
//
//        String[] alanlar = new String[]{"name","email","password"};
//        Cursor cr =db.query( "UserTable",alanlar,null,null,null,null,null );
//        String sonuc = "";
//
//        int Name = cr.getColumnIndex("name");
//        int Mail = cr.getColumnIndex("email");
//        int Password = cr.getColumnIndex("password");
//
//        cr.moveToFirst();
//        while( !cr.isAfterLast()){
//
//            sonuc += (cr.getString(Name)+ " " +cr.getString(Mail)+ " " +cr.getString(Password)+ "\n");
//            cr.moveToNext();
//        }
//        cr.close();
//       return sonuc.toString();
//
//    }
//
//
//
//
//    //Delete
//
//
//    // Updtade
//
//}
