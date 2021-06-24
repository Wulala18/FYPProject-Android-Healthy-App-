package com.example.fitnessapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.fitnessapp.Functions.FoodRecipe.Nutrition;
import com.example.fitnessapp.Functions.Reminder.Reminderss;
import com.example.fitnessapp.Functions.TipsFunction.TipsFunction;
import com.example.fitnessapp.Functions.WorkoutCategories.WorkOut;
import com.example.fitnessapp.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFrag extends Fragment implements View.OnClickListener{

    Intent intent;
    CardView workout_view,tips_view,nutrition_view,reminder_view;
    ImageSlider imageSlider;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        workout_view = view.findViewById(R.id.workout);
        imageSlider = view.findViewById(R.id.imageSlider);
        tips_view = view.findViewById(R.id.tips);
        nutrition_view = view.findViewById(R.id.nutrition);
        reminder_view = view.findViewById(R.id.reminder);


        workout_view.setOnClickListener(this);
        tips_view.setOnClickListener(this);
        nutrition_view.setOnClickListener(this);
        reminder_view.setOnClickListener(this);



        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://wallpaper.dog/large/17063056.jpg","Just Do IT"));
        slideModels.add(new SlideModel("https://i.ytimg.com/vi/88wyWNR9AAU/maxresdefault.jpg","Eat Apple Everyday"));
        slideModels.add(new SlideModel("https://wallpapercave.com/wp/wp2377663.jpg","Train Hard"));
        slideModels.add(new SlideModel("https://quotefancy.com/media/wallpaper/3840x2160/1222849-Nelly-Quote-Your-own-destiny-create-your-own-recipe.jpg","Recipes"));
        imageSlider.setImageList(slideModels, true);




            return view;
    }



    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.workout:
              intent =   new Intent(getActivity(), WorkOut.class);
              startActivity(intent);
                break;

            case R.id.tips:
              intent =  new Intent(getActivity(), TipsFunction.class);
              startActivity(intent);
                break;

            case R.id.nutrition:
               intent = new Intent(getActivity(), Nutrition.class);
               startActivity(intent);
                break;

            case R.id.reminder:
                intent = new Intent(getActivity(), Reminderss.class);
                startActivity(intent);
                break;

            default:
                break;

        }




    }


}