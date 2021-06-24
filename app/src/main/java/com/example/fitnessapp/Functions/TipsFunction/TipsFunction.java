
package com.example.fitnessapp.Functions.TipsFunction;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fitnessapp.MainInterface.Home;
import com.example.fitnessapp.R;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;




public class TipsFunction extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/Wulala18/holderjson/master/db.json";
    JsonArrayRequest request;
    List<Tipss> tips;
    RequestQueue requestQueue;
    RecyclerView recyclerView;
    Toolbar toolbar;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);



        tips = new ArrayList<>();
        toolbar = findViewById(R.id.tips_toolbar);
        recyclerView = findViewById(R.id.recyclerviewid);
        lottieAnimationView = findViewById(R.id.tipsplash);



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("We Tips You Because We Care");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(v -> startActivity(new Intent(getApplicationContext(), Home.class)));
        jsonrequest();

    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, response -> {

            JSONObject jsonObject = null;

            for (int i = 0; i < response.length(); i++) {
                try {
                    jsonObject = response.getJSONObject(i);
                    Tipss tipss = new Tipss();
                    tipss.setId(jsonObject.getInt("id"));
                    tipss.setTitle(jsonObject.getString("title"));
                    tipss.setDescription(jsonObject.getString("description"));
                    tipss.setImgg(jsonObject.getString("img"));

                    tips.add(tipss);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                setuprecyclerview(tips);

            }
        }, error -> {

        });

        requestQueue = Volley.newRequestQueue(TipsFunction.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<Tipss> tips) {


        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this, tips);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}