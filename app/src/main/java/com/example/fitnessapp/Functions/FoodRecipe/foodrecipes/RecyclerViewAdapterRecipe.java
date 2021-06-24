package com.example.fitnessapp.Functions.FoodRecipe.foodrecipes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fitnessapp.R;

import java.io.File;
import java.util.List;


public class RecyclerViewAdapterRecipe extends RecyclerView.Adapter<RecyclerViewAdapterRecipe.MyViewHolder> {

    private Context mmContext ;
    private List<Foodrecipes> fData ;





    public RecyclerViewAdapterRecipe(Context mContext, List<Foodrecipes> fData) {
        this.mmContext = mContext;
        this.fData = fData;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(mmContext).inflate(R.layout.foodrecipesrecyclerview,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(v -> {

            Intent i = new Intent(mmContext, FoodrecipeActivity.class);
            i.putExtra("title",fData.get(viewHolder.getAdapterPosition()).getName());
            i.putExtra("calories",fData.get(viewHolder.getAdapterPosition()).getCalories());
            i.putExtra("fat",fData.get(viewHolder.getAdapterPosition()).getFat());
            i.putExtra("protein",fData.get(viewHolder.getAdapterPosition()).getProtein());
            i.putExtra("sugar",fData.get(viewHolder.getAdapterPosition()).getSugar());
            i.putExtra("ingredients",fData.get(viewHolder.getAdapterPosition()).getIngredients());
            i.putExtra("instructions",fData.get(viewHolder.getAdapterPosition()).getInstructions());
            i.putExtra("images",fData.get(viewHolder.getAdapterPosition()).getImgg());
            mmContext.startActivity(i);

        });


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



        Glide.with(mmContext).load(String.valueOf(fData.get(position).getImgg())).into(holder.tv_images);

        holder.tv_recpname.setText(fData.get(position).getName());
        holder.tv_recpcaloreis.setText(fData.get(position).getCalories());
        holder.tv_recpfat.setText(fData.get(position).getFat());
        holder.tv_recpprotein.setText(fData.get(position).getProtein());
        holder.tv_recpsugar.setText(fData.get(position).getSugar());





    }

    @Override
    public int getItemCount() {

        return fData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {


       TextView tv_recpname, tv_recpcaloreis, tv_recpfat, tv_recpprotein, tv_recpsugar;
       ImageView tv_images;
       CardView view_container;



        public MyViewHolder(View itemView) {
            super(itemView);


                view_container = itemView.findViewById(R.id.recipecontain);
                tv_images = itemView.findViewById(R.id.menu_image);
                tv_recpname = itemView.findViewById(R.id.showrecipename);
                tv_recpcaloreis = itemView.findViewById(R.id.showrecipecalories);
                tv_recpfat = itemView.findViewById(R.id.showrecipefat);
                tv_recpprotein = itemView.findViewById(R.id.showrecipeprotein);
                tv_recpsugar= itemView.findViewById(R.id.showrecipesugar);



        }
    }

}
