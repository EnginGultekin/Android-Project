package com.engleg.calculatecalories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.engleg.calculatecalories.databinding.ActivityResultOfCalculateBinding;

import java.util.ArrayList;

public class ResultOfCalculate extends AppCompatActivity {

    private ActivityResultOfCalculateBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultOfCalculateBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        int calori = 0 ;    // Bunları seçilmiş olan besinlerin kalori değerlerini tutacak değişken
        int carbon = 0 ;
        int protein = 0 ;
        int yag = 0 ;

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            ArrayList<Food> arraylist = getIntent().getExtras().getParcelableArrayList("calculate");
            for (int i = 0; i < arraylist.size(); i++) {
                Log.e("ResultOfCalculate##", "Name: " + arraylist.get(i).name + "--id: " + arraylist.get(i).id);
                calori += arraylist.get(i).cal;
                protein += arraylist.get(i).protein;
                carbon  += arraylist.get(i).carbon;
                yag += arraylist.get(i).yag;
            }
        }

            binding.Calori.setText("Kalori : " + calori + " kcal ");
            binding.carbon.setText("Karbonhidrat : " + carbon + " gr ");
            binding.protein.setText("Protein : " + protein + " gr ");
            binding.yag.setText("Yağ : " + yag + " gr ");

            if (calori < 1500) {
                binding.oneri.setText("Günlük tüketilmesi gereken kalori değeri 2340 kcal olmalıdır ve sizin kalori değeriniz bu değerin çok altındadır bu nedenle daha fazla besin tüketmeye dikkat etmelisiniz ");
                binding.resim.setText("Yetersiz");
                binding.resim.setTextColor(getResources().getColor(R.color.yetersiz));
            } else if (calori > 1500 && calori < 2280) {
                binding.oneri.setText("Günlük tüketilmesi gereken kalori değeri 2340 kcal olmalıdır ve sizin kalori değeriniz bu değerin biraz altındadır bu nedenle ortalama 250 kalori değerine kadar besin tüketebilirsiniz");
                binding.resim.setText("Biraz Daha");
                binding.resim.setTextColor(getResources().getColor(R.color.birazdaha));
            } else if (calori > 2280 && calori < 2400) {
                binding.oneri.setText("Günlük tüketilmesi gereken kalori değeri 2340 kcal olmalıdır ve sizin kalori değeriniz tam olarak " + calori  +" kaloridir HARİKA! hergün bu şekilde devam edebilirsiniz");
                binding.resim.setText("Mükemmel\n✔");
                binding.resim.setTextColor(getResources().getColor(R.color.harika));
            } else if (calori > 2400 && calori < 3000) {
                binding.oneri.setText("Günlük tüketilmesi gereken kalori değeri 2340 kcal olmalıdır ancak sizin kalori değeriniz bu değerin biraz üzerine çıkmıştır  bu nedenle yediklerinize  biraz dikkat etmelisiniz");
                binding.resim.setText("Biraz Geçti");
                binding.resim.setTextColor(getResources().getColor(R.color.gecti));
            } else if (calori > 3000) {
                binding.oneri.setText("Günlük tüketilmesi gereken kalori değeri 2340 kcal olmalıdır ancak sizin kalori değeriniz bu değerin çok üzerine çıkmıştır bu nedenle yediklerinize daha fazla dikkat etmelisiniz");
                binding.resim.setText("Çok Geçti");
                binding.resim.setTextColor(getResources().getColor(R.color.uctu));
            }


        }
    }