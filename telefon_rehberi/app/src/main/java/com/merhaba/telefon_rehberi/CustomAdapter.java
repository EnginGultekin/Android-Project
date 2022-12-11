package com.merhaba.telefon_rehberi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList contact_id, contact_name, contact_number, contact_mail;
    private Activity activity;

    CustomAdapter(Activity activity, Context context, ArrayList contact_id, ArrayList contact_name, ArrayList contact_number, ArrayList contact_mail){
        this.activity = activity;
        this.context = context;
        this.contact_id = contact_id;
        this.contact_name = contact_name;
        this.contact_number = contact_number;
        this.contact_mail = contact_mail;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.contact_name_txt.setText(String.valueOf(contact_name.get(position)));
        holder.contact_number_txt.setText(String.valueOf(contact_number.get(position)));
        holder.contact_mail_txt.setText(String.valueOf(contact_mail.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(contact_id.get(position)));
                intent.putExtra("name", String.valueOf(contact_name.get(position)));
                intent.putExtra("number", String.valueOf(contact_number.get(position)));
                intent.putExtra("mail", String.valueOf(contact_mail.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contact_name.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView contact_name_txt, contact_number_txt, contact_mail_txt;
        LinearLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            contact_name_txt = itemView.findViewById(R.id.contact_name_txt);
            contact_number_txt = itemView.findViewById(R.id.contact_number_txt);
            contact_mail_txt = itemView.findViewById(R.id.contact_mail_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
