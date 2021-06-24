package com.example.fitnessapp.Functions.FoodRecipe.DIYRecipe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.Functions.FoodRecipe.Nutrition;
import com.example.fitnessapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class DIY_ViewHolder extends RecyclerView.ViewHolder {



    TextView tvrecopetitle, tvTimeAdded;



    public DIY_ViewHolder(@NonNull View itemView) {
        super(itemView);



        itemView.setOnClickListener(view -> mClickListener.onItemClick(view, getAdapterPosition()));

        itemView.setOnLongClickListener(view -> { mClickListener.onItemLongClick(view, getAdapterPosition());
            return true;
        });

        tvrecopetitle = itemView.findViewById(R.id.showdiyrecipename);
        tvTimeAdded = itemView.findViewById(R.id.showtime);

    }

    private DIY_ViewHolder.OnItemClickListener mClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(DIY_ViewHolder.OnItemClickListener clickListener) {
       mClickListener = clickListener;
    }




}

