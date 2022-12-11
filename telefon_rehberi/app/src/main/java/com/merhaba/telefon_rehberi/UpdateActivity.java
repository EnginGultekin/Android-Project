package com.merhaba.telefon_rehberi;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class UpdateActivity extends AppCompatActivity {
    EditText name_input, number_input, mail_input;
    Button update_button, delete_button;
    FloatingActionButton call_button, msg_button, email_button;

    String id, name, number, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name_input);
        number_input = findViewById(R.id.number_input);
        mail_input = findViewById(R.id.mail_input);
        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);
        call_button = findViewById(R.id.call_button);
        msg_button = findViewById(R.id.msg_button);
        email_button = findViewById(R.id.email_button);

        getAndSetIntentData();

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(name);
        }

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataAccess dbHelper = new DataAccess(UpdateActivity.this);
                name = name_input.getText().toString().trim();
                number = number_input.getText().toString().trim();
                mail = mail_input.getText().toString().trim();
                dbHelper.updateContact(id, name, number, mail);
                Intent homepage = new Intent(UpdateActivity.this, MainActivity.class);
                startActivity(homepage);
            }
        });

        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });

        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+90" + number_input.getText().toString().trim()));
                startActivity(intent);
            }
        });

        msg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("sms:+90" + number_input.getText().toString().trim()));
                startActivity(intent);
            }
        });

        email_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:" + mail_input.getText().toString().trim()));
                startActivity(intent);
            }
        });
    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("name") &&
        getIntent().hasExtra("number") && getIntent().hasExtra("mail")){
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            number = getIntent().getStringExtra("number");
            mail = getIntent().getStringExtra("mail");

            name_input.setText(name);
            number_input.setText(number);
            mail_input.setText(mail);
        }
        else {
            Toast.makeText(this, "Veri Yok!", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(name + " kişisi silinecek");
        builder.setMessage(name + " kişisini silmek istediğinizden emin misiniz ?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DataAccess dbHelper = new DataAccess(UpdateActivity.this);
                dbHelper.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

}
