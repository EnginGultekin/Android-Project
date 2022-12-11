package com.engleg.calculatecalories;

import static android.util.Log.e;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.engleg.calculatecalories.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    static ArrayList<Food> checkedFoodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle bundle= getIntent().getExtras();
        if (bundle!= null) {
            ArrayList<Food> arraylist = getIntent().getExtras().getParcelableArrayList("checkedItems");
            checkedFoodList.addAll(arraylist);
            for (int i = 0;  i<arraylist.size();i++) {
                Log.e("aasdasdsa##123",arraylist.get(i).name + arraylist.get(i).id);
            }
        }
        try {
            // Alt satırda "Musicians" adında bir veritabanı oluşturduk
            SQLiteDatabase database = this.openOrCreateDatabase("food", MODE_PRIVATE, null);
            //Burda "musicians" adında bir tablo oluşturduuk ve iki attribute verdik
            database.execSQL("CREATE TABLE IF NOT EXISTS food(id INTEGER PRIMARY KEY,name VARCHAR,cal INT,protein INT,carbon INT,yag INT)");

            // ----DİKKAT---- Burdakileri veritabanına yazdık ve o yüzden yorum satırına aldık
            //      --------  Kahvaltılıklar  --------  30 tane
            /*database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('hasYumurta',155,12,1,10)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kizYumurta',243,12,2,20)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sucYumurta',483,27,6,39)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('beyazPeynir',93,6,1,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kasPeynir',140,12,1,14)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tulumPeynir',100,6,2,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tereyagi',215,0,0,24)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kaymak',117,0,1,12)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bal',30,0,8,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tahin',175,5,6,14)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pekmez',58,0,0,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('siyahZeytin',27,0,1,2)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('yesilZeytin',29,0,1,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('salam',150,5,2,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sucuk',166,7,2,14)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sosis',60,3,0,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pastirma',75,8,0,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('gevrek',145,2,30,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('findikEzmesi',391,7,6,38)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('domates',20,1,4,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('salatalik',18,1,4,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('misirEkmek',251,5,27,13)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kepekEkmek',108,5,22,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('somunEkmek',120,6,21,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('trabzonEkmek',150,4,26,12)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tandirEkmek',110,5,28,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sacEkmek',106,7,29,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bazlama',177,5,37,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('recel',56,0,13,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('krep',187,7,28,4)"); */

            /*    --------  Ana Yemekler Dinner  --------  50 tane
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('domatesCorba',63,2,9,2)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ezogelinCorba',91,4,13,2)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ilikCorba',168,24,8,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('iskembeCorba',209,23,7,9)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kelleCorba',325,31,11,16)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mantarCorba',133,4,10,9)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mercimekCorba',91,5,16,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sebzeliCorba',87,17,1,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sutCorba',151,6,15,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tavukCorba',110,8,7,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('yaylaCorba',94,3,13,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('alaBalik',336,36,0,20)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('barbunBalik',258,44,0,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('cipraBalik',192,39,0,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('dilBalik',147,32,0,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('hamsi',230,34,0,10)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('istavrit',308,28,0,20)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kalamar',680,20,38,50)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kalkan',143,24,0,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kefal',176,30,0,6)");

            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('lufer',188,30,0,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mezgit',140,30,0,2)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sazan',279,40,0,12)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('somon',358,40,0,21)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kurufas',558,42,59,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tazefas',47,2,10,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bamya',24,3,3,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bezelye',235,11,40,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bezelye2',201,15,18,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('barbunya',242,8,22,4)");

            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('et',558,34,60,20)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('iclikofte',459,17,55,18)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('firindatavuk',291,38,1,13)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('nugget',536,32,12,40)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tavukgoysu',288,28,7,15)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tavuksand',299,31,37,2)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ciger',287,30,10,13)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('hataykebap',431,25,2,35)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('imambayildi',164,7,16,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kaburgadolmasi',342,18,18,21)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('manti',424,10,74,8)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('guvec',148,17,9,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('karnabaharYemegi',112,3,11,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('makarna',283,10,55,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pilav',259,3,40,9)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pilavbulgur',257,5,48,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mercimekliBulgur',348,11,50,10)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kokorec',226,36,5,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('borulce',245,18,34,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ispanak',38,6,1,1)");   */

            /*   --------  Meyveler  --------   25 tane
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ananas',100,1,26,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ayva',78,1,14,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bogurtlen',45,1,14,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('cilek',48,1,11,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('beyazdut',540,3,0,98)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('elma',47,1,13,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('erik',46,1,12,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('greyfurt',100,1,18,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('incir',111,1,28,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('karadut',686,4,0,112)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('armut',114,1,30,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('karpuz',45,1,11,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kavun',50,2,12,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kayisi',48,1,11,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('hurma',130,4,18,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kiraz',126,2,32,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kivi',92,0,22,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mandalina',80,1,20,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mango',90,1,23,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('muz',151,2,38,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('nar',133,3,29,2)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('portakal',101,2,25,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('seftali',47,1,11,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('uzum',104,1,27,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('visne',73,1,14,1)"); */



            /*     --------  Atıştırmalıklar  --------   20 tane
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('biskuvi',765,14,140,17)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('antepfistik',429,16,22,35)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('badem',299,9,10,27)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('finduk',628,15,16,60)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kaju',402,10,23,32)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('komple',347,9,75,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('cigkofte',361,15,64,30)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('cikolata',198,2,20,11)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('fastfood',313,13,38,12)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('iskender',755,49,78,27)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('meyvetabagi',74,1,15,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('lahmacun',221,10,32,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('hataydoner',248,34,12,32)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('patateskiz',468,5,62,22)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pide1',356,14,42,15)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pide2',220,8,54,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('pide3',320,12,41,9)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('salata',45,2,5,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('yerfis',454,20,12,39)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tursu',10,1,1,0)");  */



            /*   --------  Tatlılar  --------   25 tane
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('baklava',659,12,78,34)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bulbulyuvasi',550,5,67,30)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('cheesecake',513,10,61,23)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('etimek',225,7,32,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('gullac',143,4,21,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('islakek',570,9,62,30)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('irmikhelvasi',532,8,65,25)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('irmiktatlisi',229,6,37,5)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kazandibi',200,5,30,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kunefe',426,8,55,21)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('lokmatat',776,4,75,48)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('malaga',552,8,60,30)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('mozaik',52,8,64,30)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('muhallabi',233,5,38,4)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('profiterol',357,5,46,16)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('revani',523,9,83,14)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sufle',396,8,42,20)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('supangle',159,5,20,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sutlac',265,4,55,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('samtatlisi',440,25,201,1)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sekerpare',408,4,69,13)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tavukgogsu',118,5,23,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('tiramisu',335,8,49,10)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('vezirpar',278,3,46,12)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('waffle',350,4,19,23)");  */


          /*    --------  İçecekler  --------   25 tane
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('americano',6,0,1,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('ayran',75,3,7,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bira',139,2,10,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('bitkicayi',14,0,3,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('caysekerli',10,0,3,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('expresso',125,4,20,3)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kivicayi',24,0,7,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kutucola',201,0,35,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kutufanta',157,0,38,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('kutusprite',130,0,35,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('latte',67,6,10,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('limonata',94,0,18,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('milkshake',287,9,46,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('nescafe',75,4,15,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('oralet',24,0,7,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('portakalsuyu',120,1,30,0)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sahlep',188,6,28,6)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sicakcikolata',199,6,29,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('sut',122,7,9,7)");
            database.execSQL("INSERT INTO food (name,cal,protein,carbon,yag) VALUES ('turkkahvesi',1,0,0,0)");  */


            //Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'Demet'",null);
            Cursor cursor = database.rawQuery("SELECT * FROM food", null);

            int nameIx = cursor.getColumnIndex("name");
            int calIx = cursor.getColumnIndex("cal");
            int proteinIx = cursor.getColumnIndex("protein");
            int carbonIx = cursor.getColumnIndex("carbon");
            int yagIx = cursor.getColumnIndex("yag");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("ID : " + cursor.getInt(idIx));
                System.out.println("Name : " + cursor.getString(nameIx));
                System.out.println("Calari : " + cursor.getInt(calIx));
                System.out.println("Protein : " + cursor.getInt(proteinIx));
                System.out.println("Carbon : " + cursor.getInt(carbonIx));
                System.out.println("Yag : " + cursor.getInt(yagIx));

            }
            cursor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calculate Ekranına Gitmesi İçin
    public void calculate(View view) {
        Intent intent = new Intent(MainActivity.this, ResultOfCalculate.class);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("calculate", checkedFoodList);
        intent.putExtras(bundle);
        startActivity(intent);
        checkedFoodList.clear();
    }

    // Kahvaltı Ekranına Gitmesi İçin

    public void breakfast(View view) {

        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        intent.putExtra("type", TYPE_BREAKFAST);
        startActivity(intent);
    }

    // Dinner-Launch Ekranına Gitmesi İçin
    public void dinner(View view) {

        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        intent.putExtra("type", TYPE_DINNER);
        startActivity(intent);
    }

    // Meyve Ekranına Gitmesi İçin
    public void fruit(View view) {

        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        intent.putExtra("type", TYPE_FRUIT);
        startActivity(intent);
    }

    // Atıştırmalık Ekranına Gitmesi İçin
    public void snack(View view) {
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        intent.putExtra("type", TYPE_SNACK);
        startActivity(intent);
    }

    // Tatlı Ekranına Gitmesi İçin
    public void tatli(View view) {
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        intent.putExtra("type", TYPE_TATLI);
        startActivity(intent);
    }

    // İçecek Ekranına Gitmesi İçin
    public void drink(View view) {
        Intent intent = new Intent(MainActivity.this, FoodActivity.class);
        intent.putExtra("type", TYPE_DRINK);
        startActivity(intent);
    }

    static final int TYPE_BREAKFAST = 1;
    static final int TYPE_DINNER = 2;
    static final int TYPE_FRUIT = 3;
    static final int TYPE_SNACK = 4;
    static final int TYPE_TATLI = 5;
    static final int TYPE_DRINK = 6;

}



