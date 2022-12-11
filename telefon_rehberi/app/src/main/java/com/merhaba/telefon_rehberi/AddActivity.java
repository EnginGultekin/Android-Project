package com.merhaba.telefon_rehberi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

public class AddActivity extends AppCompatActivity {

    EditText contact_name, contact_number, contact_mail;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        contact_name = findViewById(R.id.contact_name);
        contact_number = findViewById(R.id.contact_number);
        contact_mail = findViewById(R.id.contact_mail);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                DataAccess dbHelper = new DataAccess(AddActivity.this);
                dbHelper.addContact(contact_name.getText().toString().trim(),
                        contact_number.getText().toString().trim(),
                        contact_mail.getText().toString().trim());
                Intent homepage = new Intent(AddActivity.this, MainActivity.class);
                startActivity(homepage);
            }
        });
    }
}