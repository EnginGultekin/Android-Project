package com.engleg.calculatecalories;

import static com.engleg.calculatecalories.databinding.RecyclerRowBinding.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.engleg.calculatecalories.databinding.RecyclerRowBinding;

import java.util.ArrayList;
import java.util.Objects;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodHolder> {

    ArrayList<Food> foodArrayList = new ArrayList<>();
    ArrayList<Food> checkedFoodList = new ArrayList<>();

    @NonNull
    @Override
    public FoodHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new FoodHolder(recyclerRowBinding);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodHolder holder, int position) {
        Food currentItem = foodArrayList.get(position);
        holder.binding.recycelerViewCheckBox.setText(currentItem.name);
        holder.binding.recycelerViewCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    foodArrayList.get(position).isChecked = true;
                    checkedFoodList.add(foodArrayList.get(position));
                } else {
                    foodArrayList.get(position).isChecked = false;
                    checkedFoodList.remove(foodArrayList.get(position));
                }
            }
        });
    }

    void setFoodArrayList(ArrayList<Food> list) {
        this.foodArrayList.clear();
        this.foodArrayList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (foodArrayList != null) {
            return foodArrayList.size();
        }
        return 0;
    }

    public class FoodHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding binding;

        public FoodHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
