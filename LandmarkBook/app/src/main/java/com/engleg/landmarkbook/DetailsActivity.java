package com.engleg.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.os.Bundle;

import com.engleg.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Intent intent = getIntent();

        //Casting
        LandMark selectLandMark = (LandMark) intent.getSerializableExtra("landmark");

        binding.textName.setText(selectLandMark.name);
        binding.textCountry.setText(selectLandMark.country);
        binding.image.setImageResource(selectLandMark.image);




    }
}