package com.kizilkaya.androidproje;

import android.content.Context;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;



public class MainActivity2 extends AppCompatActivity {

    Context context = this;
    ArrayList<VerileriIsle> arrayList = new ArrayList<>();
    RecyclerView r_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        r_view = findViewById(R.id.r_view);
        // LinearLayoutManager ile verilerin nasıl konumlandırılacağı belirlenir.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        linearLayoutManager.scrollToPosition(0);

        // Üstte oluşturulan düzen RecyclerView'a set edildi.
        r_view.setLayoutManager(linearLayoutManager);

        // Listeye eleman eklendi.
        arrayList.add(new VerileriIsle("Arjantin Döner","Üniversite Caddesi Üzeri","Restoran,Cafe","5"));
        arrayList.add(new VerileriIsle("Kocatepe Kahve Evi","Kaymakamlık Karşısı","Cafe","6"));
        arrayList.add(new VerileriIsle("Aspava","Gölün Yanı","Restoran","4"));

        // Listenin uzun görülmesi için döngüden faydalanarak değerler ekledik.
        for(int i = 3; i <= 20; i++){
            arrayList.add(new VerileriIsle("Restoran"+i,"Gölbaşı"+i,"Restoran","9"));
        }

        // Adapter yapımızın nesnesini oluşturup parametre gönderdik ve ardın RecyclerView'a set ettik.
        CustomAdapter customAdapter = new CustomAdapter(arrayList,context);
        r_view.setAdapter(customAdapter);

    }
}