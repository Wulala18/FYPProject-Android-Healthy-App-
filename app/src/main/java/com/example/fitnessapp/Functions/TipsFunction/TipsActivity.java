package com.example.fitnessapp.Functions.TipsFunction;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;

public class TipsActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvname, tvdedx;
    ImageView imgview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wlm);


        String titles = getIntent().getExtras().getString("title");
        String description = getIntent().getExtras().getString("description");
        String image_url = getIntent().getExtras().getString("img");

        toolbar = findViewById(R.id.tpp_toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tips of Stay Healthy");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), TipsFunction.class)));




        tvname = findViewById(R.id.tips_title);
        tvdedx = findViewById(R.id.description_tips);
        imgview = findViewById(R.id.showpictures);

        tvdedx.setMovementMethod(new ScrollingMovementMethod());


        //Set Each Values
        tvname.setText(titles);
        tvdedx.setText(description);


            //Set Image
        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(imgview);








    }


}