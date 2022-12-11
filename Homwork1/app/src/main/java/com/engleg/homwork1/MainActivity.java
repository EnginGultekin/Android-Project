package com.engleg.homwork1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import static android.view.KeyEvent.KEYCODE_ENTER;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    CheckBox checkBox;
    RadioButton radioButton1;
    RadioButton radioButton2;
    ToggleButton toggleButton;
    Spinner spinner;

    public class OnItemSelectedListenerS implements OnItemSelectedListener {
        public void  onItemSelected(AdapterView<?> parent, View view, int pos, long id){
            Toast.makeText(parent.getContext(), "Telefon Modu"+ parent.getItemAtPosition(pos).toString() + " olarak seçildi" ,Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> arg0){
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttons);
        editText = findViewById(R.id.editTextString);
        checkBox = findViewById(R.id.onay);
        radioButton1 = findViewById(R.id.erkek);
        radioButton2 = findViewById(R.id.kadin);
        toggleButton = findViewById(R.id.onoff);
        spinner = findViewById(R.id.spiner);

        Toast.makeText(MainActivity.this , "Welcome My Mobile App",Toast.LENGTH_LONG).show();
        // Bu satırda uygulama açılır açılmaz ekranda kısa süre görünen ve kaybolan bir mesaj(popap) olusturduk.

        //Bu satırı Yazınca aşağıdakiler otomatik geliyor Toastı biz Yazdık İf-Else de
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Düğmeye Basıldığında Yapılması Gerekenler Burda Yazılır
                Toast.makeText(MainActivity.this,"İşlem Gerçekleştiriliyor",Toast.LENGTH_SHORT).show();
            }
        });  // Burayı yorum al aşağıyı aç
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KEYCODE_ENTER)){
                    Toast.makeText(MainActivity.this,editText.getText(),Toast.LENGTH_SHORT).show();
                    return true;
                }else
                return false;
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()){
                    //Onay Kutusu Seçildiğinde Burdaki Kod Çalışır
                    Toast.makeText(MainActivity.this,"Onaylandı",Toast.LENGTH_SHORT).show();
                }
                else {
                    //Onay Kutusu Seçilmediği takdirde Burası Çalışır
                    Toast.makeText(MainActivity.this,"Onaylanmadı",Toast.LENGTH_SHORT).show();
                }
            }
        });

        View.OnClickListener sonuc = new View.OnClickListener() {  // Sonuc nesnesini biz olusturduk
            @Override
            public void onClick(View v) {
                RadioButton secilendugme = (RadioButton) v ;   //secilendugme nesnesini biz oluşturduk
                //Burda secilendugme değişkeni bize secilmiş kutunun nesnesini getirir ona göre burda dilediğimizi yapabiliriz
                Toast.makeText(MainActivity.this, secilendugme.getText(),Toast.LENGTH_SHORT).show();
            }
        };
        radioButton1.setOnClickListener(sonuc);
        radioButton2.setOnClickListener(sonuc);

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    //Düğme Basılı ise burdaki Kodlar Çalışacaktır
                    Toast.makeText(MainActivity.this,"Durum Aktif",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,"Durum Aktif Değil",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.telefonModu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListenerS());

    }

    public void save(View view) {
       /* // Aşağıdaki satır Buton sınıfının içinde kullandığımız uyarı mesajı oluşturan satır objemiz "alert"
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Save Info");       //Uyarı mesajını gösteren kutunun başlığı
        alert.setMessage("Are You Sure ");  //Uyarı mesajını gösteren kutunun içindeki mesaj

        // Şimdi bu uyarı mesajı için bir  "YES" bir de "No" seçenekleri oluşturalım
        // Bu  "Yes" Butonu için
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
            }
        });

        // Bu "No" Butonu için
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Don't Saved",Toast.LENGTH_LONG).show();
            }
        });

        alert.show();  */
    }


}