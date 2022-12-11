package com.engleg.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import com.engleg.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.stream.Collectors;
public class MainActivity extends AppCompatActivity {

    ArrayList<LandMark> landMarkArrayList;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landMarkArrayList = new ArrayList<>();
        //Data
        LandMark ata = new LandMark("Anıtkabir","TURKEY/ANKARA",R.drawable.anitkabir);
        LandMark galata = new LandMark("Galata Tower","TURKEY",R.drawable.galata);
        LandMark kizkulesi = new LandMark("Kız Kulesi","TURKEY",R.drawable.kizkulesi);
        LandMark pisa = new LandMark("Pisa Tower","Italy",R.drawable.pisa);
        LandMark eiffel = new LandMark("Eiffel Tower","France",R.drawable.eyfel);
        LandMark colosseum = new LandMark("Colosseum Arena","Italy",R.drawable.colosseum);
        LandMark londonBridge = new LandMark("London Bridge","England",R.drawable.londonbridge);
        LandMark artemis = new LandMark("The Temple of Artemis","GREECE",R.drawable.artemis);
        LandMark cinseddi = new LandMark("the Great Wall of China","CHINA",R.drawable.cinseddi);
        LandMark misirpiramidi = new LandMark("Egyptian Pyramid","EGYP",R.drawable.misirpiramidi);
        LandMark rodosheykeli = new LandMark("Rhodes Statue","GREECE",R.drawable.rodosheykeli);
        LandMark tacmahal = new LandMark("The Taj Mahal","INDIA",R.drawable.tacmahal);

        landMarkArrayList.add(ata);
        landMarkArrayList.add(pisa);
        landMarkArrayList.add(eiffel);
        landMarkArrayList.add(colosseum);
        landMarkArrayList.add(londonBridge);
        landMarkArrayList.add(galata);
        landMarkArrayList.add(kizkulesi);
        landMarkArrayList.add(artemis);
        landMarkArrayList.add(misirpiramidi);
        landMarkArrayList.add(rodosheykeli);
        landMarkArrayList.add(cinseddi);
        landMarkArrayList.add(tacmahal);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landMarkAdapter = new LandmarkAdapter(landMarkArrayList);
        binding.recyclerView.setAdapter(landMarkAdapter);

        /*   Burası ListView ile yapılan yerler
        //Adapter
         //ListView

        //Mapping
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,
                landMarkArrayList.stream().map(landMark -> landMark.name).collect(Collectors.toList()));
        binding.listview.setAdapter(arrayAdapter);

        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               //Toast.makeText(MainActivity.this,landMarkArrayList.get(position).name,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);
                intent.putExtra("landmark",landMarkArrayList.get(position));
                startActivity(intent);
            }
        });   */
    }
}