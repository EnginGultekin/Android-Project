package com.example.shashank.login;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteUsers extends MainActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    Button sil;
    EditText name;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_users);

        sil=(Button) findViewById(R.id.sil);

        email=(EditText)findViewById(R.id.editEmail);


        sil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                silme(email.getText().toString());


                Intent intent = new Intent(DeleteUsers.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void silme(String email)
    {
        sqLiteDatabaseObj = sqLiteHelper.getReadableDatabase();

        sqLiteDatabaseObj.delete(SQLiteHelper.TABLE_NAME,"email"+"=?",new String[]{email});
    }
}