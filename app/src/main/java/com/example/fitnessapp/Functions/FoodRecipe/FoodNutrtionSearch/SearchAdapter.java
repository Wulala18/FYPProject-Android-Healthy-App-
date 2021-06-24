package com.example.fitnessapp.Functions.FoodRecipe.FoodNutrtionSearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;

import java.util.List;



public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder>
{

    private Context context;
    private List<Food> food;

    public SearchAdapter(Context context, List<Food> food) {

        this.context = context;
        this.food = food;
    }


    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_items, parent,false);
        return new SearchViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        holder.name.setText(food.get(position).getName());
        holder.caloriesss.setText(food.get(position).getCalories());
        holder.sugarss.setText(food.get(position).getSugar());
        holder.proteins.setText(food.get(position).getProtein());
        holder.fatss.setText(food.get(position).getFat());
        holder.carbo.setText(food.get(position).getCabor());




    }

    @Override
    public int getItemCount() {
        return food.size();
    }
}


class SearchViewHolder extends RecyclerView.ViewHolder{

    TextView name,caloriesss,sugarss, proteins,fatss, carbo;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);


        name = itemView.findViewById(R.id.showname);
        caloriesss = itemView.findViewById(R.id.showcalorie);
        sugarss = itemView.findViewById(R.id.showsugar);
        proteins = itemView.findViewById(R.id.showprotein);
        fatss = itemView.findViewById(R.id.showfat);
        carbo = itemView.findViewById(R.id.showcarbo);




    }


}