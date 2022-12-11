package com.engleg.merhabasqlite;

public class Kitap {
    public int id;
    public String kitapadi;
    public int yil;

    public Kitap(){
    }

    public Kitap(int id, String kitapadi, int yil) {
        this.id = id;
        this.kitapadi = kitapadi;
        this.yil = yil;
    }

    public Kitap(String kitapadi, int yil) {
        this.kitapadi = kitapadi;
        this.yil = yil;
    }
}
