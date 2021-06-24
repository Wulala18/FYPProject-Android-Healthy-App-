package com.example.fitnessapp.Functions.FoodRecipe.DIYRecipe;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;

import java.util.List;

public class  DIYAdapter extends RecyclerView.Adapter<DIY_ViewHolder> {


     DIY_Show_Recipe showrecipe;
     List<DIYrecipe> foodrecipeslist;





    public DIYAdapter(DIY_Show_Recipe showrecipe, List<DIYrecipe> foodrecipeslist) {
        this.showrecipe = showrecipe;
        this.foodrecipeslist = foodrecipeslist;

    }





    @NonNull
    @Override
    public DIY_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipediylayout, parent, false);

       DIY_ViewHolder diyViewHolder = new DIY_ViewHolder(view);

       diyViewHolder.setOnItemClickListener(new DIY_ViewHolder.OnItemClickListener() {
           @Override
           public void onItemClick(View view, final int position) {

               String title = foodrecipeslist.get(position).getTitlerecipe();
               String ingre = foodrecipeslist.get(position).getIngredientsrecipe();
               String instruc = foodrecipeslist.get(position).getInstructionrecipe();
           }

           @Override
           public void onItemLongClick(View view, int position) {

               AlertDialog.Builder builder = new AlertDialog.Builder(showrecipe);
               String [] options = {"Update", "Delete"};
               builder.setItems(options, (dialogInterface, i) -> {
                   if(i == 0)
                   {
                       String id = foodrecipeslist.get(position).getIdd();
                       String foodtitle = foodrecipeslist.get(position).getTitlerecipe();
                       String foodingredients = foodrecipeslist.get(position).getIngredientsrecipe();
                       String foodinstructions = foodrecipeslist.get(position).getInstructionrecipe();
                       String tempid = foodrecipeslist.get(position).getDid();

                       Intent intent = new Intent(showrecipe, DIY_Create_Recipe.class);

                       intent.putExtra("RecipeID", id);
                       intent.putExtra("tempID", tempid);
                       intent.putExtra("RecipeTitle", foodtitle);
                       intent.putExtra("RecipeIngredients", foodingredients);
                       intent.putExtra("RecipeInstructions", foodinstructions);
                       showrecipe.startActivity(intent);

                   }if (i == 1)
                   {
                        showrecipe.deleteRecipeData(position);
                   }
               }).create().show();
           }
       });

       return  diyViewHolder;


    }

    @Override
    public void onBindViewHolder(@NonNull DIY_ViewHolder holder, int position) {

        holder.tvrecopetitle.setText(foodrecipeslist.get(position).getTitlerecipe());
        holder.tvTimeAdded.setText(foodrecipeslist.get(position).getTimestamp());



        /*DIYrecipe diYrecipe = foodrecipeslist.get(position);
        if(holder instanceof Foodrecipeholder)
        {
            Foodrecipeholder foodrecipeholder = (Foodrecipeholder)holder;
            foodrecipeholder.tvrecopetitle.setText(diYrecipe.getTitlerecipe());
            foodrecipeholder.tvrecopetitle.setText(diYrecipe.getIngredientsrecipe());
            foodrecipeholder.tvrecopetitle.setText(diYrecipe.getInstructionrecipe());

        }*/
    }

    @Override
    public int getItemCount() {
      return foodrecipeslist.size();

    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

  /*  interface  OnrecipeClick
    {
        void onItemClick(View view, int position, String itemId);
    }

    public void setOnrecipeClick(OnrecipeClick onrecipeClick)
    {
        this.onrecipeClick = onrecipeClick;
    }

    public static class Foodrecipeholder extends RecyclerView.ViewHolder
    {
        TextView tvrecopetitle, tvTimeAdded;
       // View mView;

        public Foodrecipeholder(@NonNull View itemView) {
            super(itemView);

            //mView = itemView;

            tvrecopetitle = itemView.findViewById(R.id.showdiyrecipename);
            tvTimeAdded = itemView.findViewById(R.id.showtime);

           // itemView.setOnClickListener(view -> onrecipeClick.onItemClick(view, getAdapterPosition(), foodrecipeslist.get(getAdapterPosition()).getIdd()));
        }
    }*/
}
