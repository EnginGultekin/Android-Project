package com.engleg.calculatecalories;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.engleg.calculatecalories.MainActivity.*;
import com.engleg.calculatecalories.databinding.ActivityFoodBinding;

import java.util.ArrayList;

public class FoodActivity extends AppCompatActivity {

    private ActivityFoodBinding binding;
    ArrayList<Food> foodArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFoodBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FoodAdapter foodAdapter = new FoodAdapter();
        binding.recyclerView.setAdapter(foodAdapter);

        int type = this.getIntent().getIntExtra("type", -1);
        Log.e("onCreate: ", type + "");
        if (type == 1) {
            Log.e("type", "onCreate: ");
            foodAdapter.setFoodArrayList(provideBreakfast());
        }
        else if (type == 2) {
            Log.e("type", "onCreate: ");
            foodAdapter.setFoodArrayList(provideDinner());
        }
        else if (type == 3) {
            Log.e("type", "onCreate: ");
            foodAdapter.setFoodArrayList(provideFruit());
        }
        else if (type == 4) {
            Log.e("type", "onCreate: ");
            foodAdapter.setFoodArrayList(provideSnack());
        }
        else if (type == 5) {
            Log.e("type", "onCreate: ");
            foodAdapter.setFoodArrayList(provideTatli());
        }
        else if (type == 6) {
            Log.e("type", "onCreate: ");
            foodAdapter.setFoodArrayList(provideDrink());
        }


        binding.tamam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("checkedItems", foodAdapter.checkedFoodList);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }

    private ArrayList<Food> provideBreakfast() {
        ArrayList<Food> breakList = new ArrayList<>();

        Food hasYumurta = new Food(1, "Yumurta (Haşlanmış 2 Adet)" ,155,12,1,10);
        Food kizYumurta = new Food(2, "Yumurta (Kızarmış 2 Adet)",243,12,2,20);
        Food sucYumurta = new Food(3, "Yumurta (Sucuklu 2 Adet)",483,27,6,39);
        Food beyazPeynir = new Food(4, "Peynir (Beyaz 30gr)",93,6,1,7);
        Food kasPeynir = new Food(5, "Peynir (Kaşar 40gr)",140,12,1,14);
        Food tulumPeyniri = new Food(6, "Peynir (Tulum 30gr)",100,12,7,7);
        Food tereyagi = new Food(7, "Tereyağı (30gr)",1215,6,0,24);
        Food kaymak = new Food(8, "Kaymak (20gr)",117,0,1,12);
        Food bal = new Food(9, "Bal (10gr)",30,0,8,0);
        Food tahin = new Food(10, "Tahin (30gr)",175,0,6,14);
        Food pekmez = new Food(11, "Pekmez (20gr)",58,0,0,0);
        Food siyahZeytin = new Food(12, "Zeytin (Siyah 23gr)",27,0,1,2);
        Food yesilZeytin = new Food(13, "Zeytin (Yeşil 20gr) ",29,0,1,3);
        Food salam = new Food(14, "Salam (50gr)",150,5,2,13);
        Food sucuk = new Food(15, "Sucuk (50gr)",166,7,2,14);
        Food sosis = new Food(16, "Sosis (40gr)",60,3,0,4);
        Food pastirma = new Food(17, "Pastırma (30gr)",75,8,0,4);
        Food gevrek = new Food(18, "Gevrek (40gr)",145,2,30,1);
        Food findikEzmesi = new Food(19, "Fındık Ezmesi (60gr)",391,7,6,38);
        Food domates = new Food(20, "Domates (1 Adet)",20,1,4,0);
        Food salatalik = new Food(21, "Salatalık (1 Adet)",18,1,4,0);
        Food misirEkmek = new Food(22, "Ekmek (Mısır 80gr)",251,5,27,3);
        Food kepekEkmek = new Food(23, "Ekmek (Kepekli 50gr)",108,5,22,1);
        Food somunEkmek = new Food(24, "Ekmek (Somun 50gr)",120,6,21,1);
        Food trabzonEkmek = new Food(25, "Ekmek (Trabzon 50gr)",150,4,26,12);
        Food tandirEkmek = new Food(26, "Ekmek (Tandır 50gr)",110,5,28,1);
        Food sacEkmek = new Food(27, "Ekmek (Sac 50gr)",106,7,29,1);
        Food bazlama = new Food(28, "Bazlama (50gr)",177,5,37,0);
        Food recel = new Food(29, "Reçel (20 gr)",56,0,13,0);
        Food krep = new Food(30, "Krep (100 gr)",1187,7,28,4);


        breakList.add(bal);
        breakList.add(bazlama);
        breakList.add(domates);
        breakList.add(misirEkmek);
        breakList.add(tandirEkmek);
        breakList.add(somunEkmek);
        breakList.add(trabzonEkmek);
        breakList.add(sacEkmek);
        breakList.add(kepekEkmek);
        breakList.add(findikEzmesi);
        breakList.add(gevrek);
        breakList.add(kaymak);
        breakList.add(krep);
        breakList.add(pekmez);
        breakList.add(beyazPeynir);
        breakList.add(tulumPeyniri);
        breakList.add(kasPeynir);
        breakList.add(pastirma);
        breakList.add(recel);
        breakList.add(salam);
        breakList.add(salatalik);
        breakList.add(sosis);
        breakList.add(sucuk);
        breakList.add(tahin);
        breakList.add(tereyagi);
        breakList.add(hasYumurta);
        breakList.add(kizYumurta);
        breakList.add(sucYumurta);
        breakList.add(siyahZeytin);
        breakList.add(yesilZeytin);
        return breakList;
    }

    private ArrayList<Food> provideDinner() {
        ArrayList<Food> dinnerList = new ArrayList<>();

        Food alaBalik = new Food(42, "Balık (Alabalık 200gr)",336,36,0,20);
        Food barbunBalik = new Food(43, "Balık (Barbun 200gr)",258,44,0,6);
        Food cipraBalik = new Food(44, "Balık (Çipura 200gr)",192,39,0,4);
        Food dilBalik = new Food(45, "Balık (Dilbalığı 150gr)",147,32,0,3);
        Food hamsi = new Food(46, "Balık (Hamsi 200gr)",230,34,0,10);
        Food istavrit = new Food(47, "Balık (İstavrit 150gr)",308,28,0,20);
        Food kalamar = new Food(48, "Balık (Kalamar 230gr)",680,20,38,50);
        Food kalkan = new Food(49, "Balık (Kalkan 150gr)",143,24,0,4);
        Food kefal = new Food(50, "Balık (Kefal 150gr)",176,30,0,6);
        Food lufer = new Food(51, "Balık (Lüfer 150gr)",188,30,0,7);
        Food mezgit = new Food(52, "Balık (Mezgit 200gr)",140,30,0,2);
        Food sazan = new Food(53, "Balık (Sazan 220gr)",279,40,0,12);
        Food somon = new Food(54, "Balık (Somon 200gr)",258,40,0,21);
        Food bamya = new Food(57, "Bamya (120gr)",24,3,3,0);
        Food barbunya = new Food(60, "Barbunya (150gr)",242,8,22,4);
        Food bezelye = new Food(58, "Bezelye (Etsiz 350gr)",235,11,40,4);
        Food bezelye2 = new Food(59, "Bezelye (Etli 250gr)",201,15,18,6);
        Food borulce = new Food(79, "Börülce (200gr)",245,18,34,3);
        Food ciger = new Food(67, "Ciğer (150gr)",287,30,10,13);
        Food domatesCorba = new Food(31, "Çorba (Domates 200gr)",63,2,9,2);
        Food ezogelinCorba = new Food(32, "Çorba (Ezo Gelin 200gr)",91,4,13,2);
        Food ilikCorba = new Food(33, "Çorba (İlik 150gr)",168,24,8,7);
        Food iskembeCorba = new Food(34, "Çorba (İşkembe 150gr)",209,23,7,9);
        Food kelleCorba = new Food(35, "Çorba (Kellepaça 240gr)",325,31,11,16);
        Food mantarCorba = new Food(36, "Çorba (Mantar 200gr)",133,4,10,9);
        Food mercimekCorba = new Food(37, "Çorba (Mercimek 200gr)",91,5,16,1);
        Food sebzeliCorba = new Food(38, "Çorba (Sebzeli 220gr)",87,17,1,1);
        Food sutCorba = new Food(39, "Çorba (Süt 200gr)",151,6,15,6);
        Food tavukCorba = new Food(40, "Çorba (Tavuk Suyu 200gr)",110,8,7,4);
        Food yaylaCorba = new Food(41, "Çorba (Yayla 200gr)",94,3,13,3);
        Food iclikofte = new Food(62, "İçli Köfte (210gr)",459,17,55,18);
        Food imambayidi = new Food(69, "İmam Bayıldı (385gr)",164,7,16,7);
        Food guvec = new Food(72, "Güveç (250gr)",148,17,9,4);
        Food hataykebap = new Food(68, "Hatay Kebap (180gr)",431,25,2,35);
        Food ispanak = new Food(80, "Ispanak (200gr)",38,6,1,1);
        Food kaburgaDolmasi = new Food(70, "Kaburga Dolması (200gr)",342,18,18,21);
        Food karnabaharYemegi = new Food(73, "Karnabahar Yemeği (250gr)",112,3,11,6);
        Food et = new Food(61, "Kırmızı Et (250gr)",558,34,60,20);
        Food kokorec = new Food(78, "Kokoreç (240gr)",226,36,5,6);
        Food kurufas = new Food(55, "Kuru Fasülye (200gr)",558,42,59,3);
        Food makarna = new Food(74, "Makarna (180gr)",283,10,55,1);
        Food manti = new Food(71, "Mantı (250gr)",424,10,74,8);
        Food mercimekliBulgur = new Food(77, "Mercimekli Bulgur (200gr)",348,11,50,10);
        Food pilavbulgur = new Food(76, "Pilav (Meyhane) (220gr)",257,5,48,5);
        Food pilav = new Food(75, "Pilav (Pirinç) (160gr)",259,3,40,9);
        Food firindatavuk = new Food(63, "Tavuk (Fırında 210)",291,38,1,13);
        Food nugget = new Food(64, "Tavuk Nugget (200gr)",536,32,12,40);
        Food tavukgoysu = new Food(65, "Tavuk Göğsü (170gr)",288,28,7,15);
        Food tavuksand = new Food(66, "Tavuk Sandviç (200gr)",299,31,37,2);
        Food tazefas = new Food(56, "Taze Fasülye (150gr)",47,2,10,0);

        dinnerList.add(alaBalik);
        dinnerList.add(barbunBalik);
        dinnerList.add(cipraBalik);
        dinnerList.add(dilBalik);
        dinnerList.add(hamsi);
        dinnerList.add(istavrit);
        dinnerList.add(kalamar);
        dinnerList.add(kalkan);
        dinnerList.add(kefal);
        dinnerList.add(lufer);
        dinnerList.add(mezgit);
        dinnerList.add(somon);
        dinnerList.add(bamya);
        dinnerList.add(barbunya);
        dinnerList.add(bezelye);
        dinnerList.add(bezelye2);
        dinnerList.add(borulce);
        dinnerList.add(ciger);
        dinnerList.add(domatesCorba);
        dinnerList.add(ezogelinCorba);
        dinnerList.add(ilikCorba);
        dinnerList.add(iskembeCorba);
        dinnerList.add(kelleCorba);
        dinnerList.add(mantarCorba);
        dinnerList.add(mercimekCorba);
        dinnerList.add(sebzeliCorba);
        dinnerList.add(sutCorba);
        dinnerList.add(tavukCorba);
        dinnerList.add(yaylaCorba);
        dinnerList.add(iclikofte);
        dinnerList.add(imambayidi);
        dinnerList.add(guvec);
        dinnerList.add(hataykebap);
        dinnerList.add(ispanak);
        dinnerList.add(kaburgaDolmasi);
        dinnerList.add(karnabaharYemegi);
        dinnerList.add(et);
        dinnerList.add(kokorec);
        dinnerList.add(kurufas);
        dinnerList.add(makarna);
        dinnerList.add(manti);
        dinnerList.add(mercimekliBulgur);
        dinnerList.add(pilavbulgur);
        dinnerList.add(pilav);
        dinnerList.add(firindatavuk);
        dinnerList.add(tavukgoysu);
        dinnerList.add(nugget);
        dinnerList.add(tavuksand);
        dinnerList.add(tazefas);
        return dinnerList;
    }

    private ArrayList<Food> provideFruit() {
        ArrayList<Food> fruitList = new ArrayList<>();
        Food ananas = new Food(81, "Ananas (200gr)",100,1,26,0);
        Food armut = new Food(91, "Armut (200gr)",114,1,30,0);
        Food ayva = new Food(82, "Ayva (200gr)",78,1,14,1);
        Food beyazdut = new Food(85, "Beyaz Dut (200gr)",540,3,0,98);
        Food bogurtlen = new Food(83, "Böğürtlen (150gr)",45,2,4,1);
        Food cilek = new Food(84, "Çilek (150gr)",48,1,11,0);
        Food elma = new Food(86, "Elma (100gr)",47,1,13,0);
        Food erik = new Food(87, "Erik (100gr)",46,1,12,0);
        Food greyfurt = new Food(88, "Greyfurt (200gr)",100,1,18,0);
        Food hurma = new Food(95, "Hurma (100gr)",130,4,18,5);
        Food incir = new Food(89, "İncir (150gr)",111,1,28,1);
        Food karadut = new Food(90, "Karadut (200gr)",686,4,0,112);
        Food karpuz = new Food(92, "Karpuz (150gr)",45,1,11,0);
        Food kavun = new Food(93, "Kavun (180gr)",1,2,12,0);
        Food kayisi = new Food(94, "Kayısı (100gr)",48,1,11,0);
        Food kiraz = new Food(96, "Kiraz (200gr)",126,2,32,1);
        Food kivi = new Food(97, "Kivi (150gr)",92,0,22,1);
        Food mandalina = new Food(98, "Mandalina (150gr)",80,1,20,0);
        Food mango = new Food(99, "Mango (150gr)",90,1,23,1);
        Food muz = new Food(100, "Muz (170gr)",151,1,38,1);
        Food nar = new Food(101, "Nar (160gr)",133,1,29,2);
        Food portakal = new Food(102, "Portakal (220gr)",101,2,25,0);
        Food seftali = new Food(103, "Şeftali (120gr)",47,1,11,0);
        Food uzum = new Food(104, "Üzüm (150gr)",104,1,27,0);
        Food visne = new Food(105, "Vişne (120gr)",73,1,14,1);

        fruitList.add(ananas);
        fruitList.add(armut);
        fruitList.add(ayva);
        fruitList.add(beyazdut);
        fruitList.add(bogurtlen);
        fruitList.add(cilek);
        fruitList.add(elma);
        fruitList.add(erik);
        fruitList.add(greyfurt);
        fruitList.add(hurma);
        fruitList.add(incir);
        fruitList.add(karadut);
        fruitList.add(karpuz);
        fruitList.add(kavun);
        fruitList.add(kayisi);
        fruitList.add(kiraz);
        fruitList.add(kivi);
        fruitList.add(mandalina);
        fruitList.add(mango);
        fruitList.add(muz);
        fruitList.add(nar);
        fruitList.add(portakal);
        fruitList.add(seftali);
        fruitList.add(uzum);
        fruitList.add(visne);

        return fruitList;
    }

    private ArrayList<Food> provideSnack() {
        ArrayList<Food> snackList = new ArrayList<>();
        Food biskuvi = new Food(106, "Bisküvi (1 Paket)",765,14,140,17);
        Food antepfistik = new Food(107, "Çerez (Antep F. 75gr)",429,16,22,35);
        Food badem = new Food(108, "Çerez (Badem 50gr)",299,9,10,27);
        Food finduk = new Food(109, "Çerez (Fındık 100gr)",628,15,16,60);
        Food kaju = new Food(110, "Çerez (Kaju 70gr)",402,10,23,32);
        Food komple = new Food(111, "Çerez (Karışık 100gr)",347,9,75,5);
        Food yerfis = new Food(124, "Çerez (Yer F. 80gr)",454,20,12,39);
        Food cigkofte = new Food(112, "Çiğ Köfte (150gr)",361,15,64,30);
        Food cikolata = new Food(113, "Çikolata (1 Paket)",198,2,20,11);
        Food fastfood = new Food(114, "Hamburger (1 Adet)",313,13,38,12);
        Food hataydoner = new Food(118, "Hatay Usülü Döner (1 adet)",248,34,12,32);
        Food iskender = new Food(115, "İskender (1 Adet)",755,49,78,27);
        Food meyvetabagi = new Food(116, "Meyve Tabağı (150gr)",74,1,15,1);
        Food lahmacun = new Food(117, "Lahmacun (150gr)",221,10,32,5);
        Food patateskiz = new Food(119, "Patates Kızartması (200gr)",468,5,62,22);
        Food pide1 = new Food(120, "Pide (Etli 170gr) ",1356,14,42,15);
        Food pide2 = new Food(121, "Pide (Karışık 170gr)",220,8,54,7);
        Food pide3 = new Food(122, "Pide (Tavuklu 170gr)",1320,12,41,9);
        Food salata = new Food(123, "Salata (150gr)",454,20,12,39);
        Food tursu = new Food(125, "Turşu (100gr)",10,1,1,0);

        snackList.add(biskuvi);
        snackList.add(antepfistik);
        snackList.add(badem);
        snackList.add(finduk);
        snackList.add(kaju);
        snackList.add(komple);
        snackList.add(yerfis);
        snackList.add(cigkofte);
        snackList.add(cikolata);
        snackList.add(fastfood);
        snackList.add(hataydoner);
        snackList.add(iskender);
        snackList.add(meyvetabagi);
        snackList.add(lahmacun);
        snackList.add(patateskiz);
        snackList.add(pide1);
        snackList.add(pide2);
        snackList.add(pide3);
        snackList.add(salata);
        snackList.add(tursu);

        return snackList;
    }

    private ArrayList<Food> provideTatli() {
        ArrayList<Food> tatList = new ArrayList<>();
        Food baklava = new Food(126, "Baklava (160gr)",659,12,78,34);
        Food bulbulyuvasi = new Food(127, "Bülbül Yuvası (120gr)",550,5,67,30);
        Food cheesecake = new Food(128, "Cheesecake (150gr)",516,10,61,23);
        Food etimek = new Food(129, "Etimek Tatlısı (180gr)",225,7,32,5);
        Food gullac = new Food(130, "Güllaç (110gr)",143,4,21,5);
        Food islakek = new Food(131, "Islak Kek (150gr)",570,9,62,30);
        Food irmikhelvasi = new Food(132, "İrmik Helvası (100gr)",532,8,65,25);
        Food irmiktatlisi = new Food(133, "İrmik Tatlısı (150gr)",229,6,37,5);
        Food kazandibi = new Food(134, "Kazandibi (150gr)",200,5,30,6);
        Food kunefe = new Food(135, "Künefe (120gr)",426,8,55,21);
        Food lokmatat = new Food(136, "Lokma Tatlısı (150gr)",776,4,75,48);
        Food malaga = new Food(137, "Malaga (150gr)",552,8,60,30);
        Food mozaik = new Food(138, "Mozaik (150gr)",342,3,22,8);
        Food muhallabi = new Food(139, "Muhallebi (150gr)",233,5,38,4);
        Food profiterol = new Food(140, "Profiterol (150gr)",357,5,146,16);
        Food revani = new Food(141, "Revani (150gr)",523,9,83,14);
        Food sufle = new Food(142, "Sufle (110gr)",396,8,42,20);
        Food supangle = new Food(143, "Supangle (130gr)",159,5,20,7);
        Food sutlac = new Food(144, "Sütlaç (250gr)",265,4,55,3);
        Food samtatlisi = new Food(145, "Şam Tatlısı (120gr)",440,25,201,1);
        Food sekerpare = new Food(146, "Şekerpare (150gr)",408,4,69,13);
        Food tavukgogsu = new Food(147, "Tavuk Göğsü (150gr)",118,5,23,0);
        Food tiramisu = new Food(148, "Tiramisu (150gr)",335,8,44,10);
        Food vezirpar = new Food(149, "Vezir Parmağı (100gr)",278,3,46,12);
        Food waffle = new Food(150, "Waffle (100gr)",350,4,19,23);

        tatList.add(baklava);
        tatList.add(bulbulyuvasi);
        tatList.add(cheesecake);
        tatList.add(etimek);
        tatList.add(gullac);
        tatList.add(islakek);
        tatList.add(irmikhelvasi);
        tatList.add(irmiktatlisi);
        tatList.add(kazandibi);
        tatList.add(kunefe);
        tatList.add(lokmatat);
        tatList.add(malaga);
        tatList.add(mozaik);
        tatList.add(muhallabi);
        tatList.add(profiterol);
        tatList.add(revani);
        tatList.add(sufle);
        tatList.add(supangle);
        tatList.add(sutlac);
        tatList.add(samtatlisi);
        tatList.add(sekerpare);
        tatList.add(tavukgogsu);
        tatList.add(tiramisu);
        tatList.add(vezirpar);
        tatList.add(waffle);

        return tatList;
    }

    private ArrayList<Food> provideDrink() {
        ArrayList<Food> drinkList = new ArrayList<>();
        Food americano = new Food(151, "Americano (1 Bardak)",6,0,1,0);
        Food ayran = new Food(152, "Ayran (1 Bardak)",75,3,7,3);
        Food bira = new Food(153, "Bira (1 Bardak)",139,2,10,0);
        Food bitkicayi = new Food(154, "Bitki Çayı (1 Fincan)",14,0,3,0);
        Food caysekerli = new Food(155, "Çay (Şekerli 1 Fincan)",10,0,3,0);
        Food expresso = new Food(156, "Expresso (1 Bardak)",125,4,20,3);
        Food kivicayi = new Food(157, "Kiyi Çayı (1 Bardak)",24,0,7,0);
        Food kutucola = new Food(158, "Kutu Cola (1 Adet)",201,0,35,0);
        Food kutufanta = new Food(159, "Kutu Fanta (1 Adet)",157,0,38,0);
        Food kutusprite = new Food(160, "Kutu Sprite (1 Adet)",130,0,35,0);
        Food latte = new Food(161, "Latte (1 Bardak)",67,6,10,0);
        Food limonata = new Food(162, "Limonata (1 Bardak)",94,0,18,0);
        Food milkshake = new Food(163, "Milkshake (1 Bardak)",287,9,46,7);
        Food nescafe = new Food(164, "Nescafe (1 Bardak)",75,4,15,0);
        Food oralet = new Food(165, "Oralet (1 Fincan)",24,0,7,0);
        Food portakalsuyu = new Food(166, "Partakal Suyu (1 Bardak)",120,0,30,0);
        Food sahlep = new Food(167, "Sahlep (1 Bardak)",188,6,28,6);
        Food sicakcikolata = new Food(168, "Sıcak Çikolata (1 Bardak)",199,6,29,7);
        Food sut = new Food(169, "Süt (1 Bardak)",122,7,9,7);
        Food turkkahvesi = new Food(170, "Türk Kahvesi (1 Fincan)",1,0,0,0);

        drinkList.add(americano);
        drinkList.add(ayran);
        drinkList.add(bira);
        drinkList.add(bitkicayi);
        drinkList.add(caysekerli);
        drinkList.add(expresso);
        drinkList.add(kivicayi);
        drinkList.add(kutucola);
        drinkList.add(kutufanta);
        drinkList.add(kutusprite);
        drinkList.add(latte);
        drinkList.add(limonata);
        drinkList.add(milkshake);
        drinkList.add(nescafe);
        drinkList.add(oralet);
        drinkList.add(portakalsuyu);
        drinkList.add(sahlep);
        drinkList.add(sicakcikolata);
        drinkList.add(sut);
        drinkList.add(turkkahvesi);

        return drinkList;
    }
}