package com.example.fitnessapp.Functions.FoodRecipe.FoodNutrtionSearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.fitnessapp.Functions.FoodRecipe.Nutrition;
import com.example.fitnessapp.R;
import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

public class healthyfood extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Toolbar toolbar;
    SearchAdapter adapter;
    MaterialSearchBar materialSearchBar;
    List<String> suggestlist = new ArrayList<>();
    Databasefood database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthyfood);


        //ini view
        toolbar = findViewById(R.id.searchback_toolbar);
        recyclerView = findViewById(R.id.recyce_search);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        materialSearchBar = findViewById(R.id.searchbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Search Food Nutrition");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> {
            startActivity(new Intent(getApplicationContext(), Nutrition.class));
        });

        //ini database
        database = new Databasefood(this);


        //setup search bar
        materialSearchBar.setHint("Search");
        materialSearchBar.setCardViewElevation(10);
        loadSuggestions();

        materialSearchBar.addTextChangeListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                List<String> suggest = new ArrayList<>();
                for (String search : suggestlist) {
                    if (search.toLowerCase().contains(materialSearchBar.getText().toLowerCase()))
                        suggest.add(search);
                }
                materialSearchBar.setLastSuggestions(suggest);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        materialSearchBar.setOnSearchActionListener(new MaterialSearchBar.OnSearchActionListener() {
            @Override
            public void onSearchStateChanged(boolean enabled) {
                if (!enabled)
                    recyclerView.setAdapter(adapter);
            }

            @Override
            public void onSearchConfirmed(CharSequence text) {

                startSearch(text.toString());

            }

            @Override
            public void onButtonClicked(int buttonCode) {

            }
        });


        adapter = new SearchAdapter(this, database.getFood());
        recyclerView.setAdapter(adapter);




    }


    private void startSearch(String text) {

      adapter= new SearchAdapter(this,database.getFoodByName(text));
      recyclerView.setAdapter(adapter);
    }

    private void loadSuggestions() {
        suggestlist = database.getName();
        materialSearchBar.setLastSuggestions(suggestlist);
    }
}