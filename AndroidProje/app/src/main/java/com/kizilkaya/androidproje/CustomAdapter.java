package com.kizilkaya.androidproje;


import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<VerileriIsle> arrayList;
    LayoutInflater layoutInflater;
    Context context;

    public CustomAdapter(ArrayList<VerileriIsle> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    // Her bir satır için temsil edilecek olan arayüz belirlenir.
    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.satir_genel_ayari,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    // Her bir satırın içeriği belirlenir.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txt_kisi_adi.setText(arrayList.get(position).getIsim());
        holder.txt_kisi_dogum_tarihi.setText(arrayList.get(position).getAdres());
        holder.txt_cinsi.setText(arrayList.get(position).getCinsi());
        holder.txt_puan.setText(arrayList.get(position).getPuan());

        holder.ll_liste_elemani.setTag(holder);
        // Listedeki elemanlara tıklanıdığında yapılacak olan işlem...
        holder.ll_liste_elemani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewHolder holder1 = (ViewHolder)view.getTag();
                int position = holder1.getPosition();
               String yazdir = arrayList.get(position).getIsim();

               Toast.makeText(context, ""+yazdir, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context,RMainActivity.class);
                intent.putExtra("name",arrayList.get(position).getIsim());
                context.startActivity(intent);



            }
        });

    }

    // Listedeki eleman sayısı kadar işlemin yapılmasını sağladık. Elle de bir değer verilebilirdi.
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // Elemanlarımıza erişip tanımladığımız yer
    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_kisi_adi, txt_kisi_dogum_tarihi, txt_cinsi,txt_puan;

        LinearLayout ll_liste_elemani;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_kisi_adi = itemView.findViewById(R.id.txt_restoran_adi);
            txt_kisi_dogum_tarihi = itemView.findViewById(R.id.txt_adres);
            txt_cinsi=itemView.findViewById(R.id.txt_cinsi);
            txt_puan = itemView.findViewById(R.id.txt_puan);

            ll_liste_elemani = itemView.findViewById(R.id.ll_liste_elemani);
        }
    }
}