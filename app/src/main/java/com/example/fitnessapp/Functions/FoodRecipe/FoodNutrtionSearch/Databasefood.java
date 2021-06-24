package com.example.fitnessapp.Functions.FoodRecipe.FoodNutrtionSearch;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Databasefood extends SQLiteAssetHelper {


    private static final String DB_NAME = "databasefood.db";
    private static final int DB_VER=7;


    public Databasefood(Context context) {

        super(context, DB_NAME, null, DB_VER);
    }


//get all food info
    public List<Food> getFood()
     {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "Name", "Calories", "Sugar", "Protein","Fat","Carbohydrates"};
        String tablename = "healthyfood";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db,sqlSelect,null,null,null,null,null);
        List<Food> result = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setId(cursor.getInt(cursor.getColumnIndex("id")));
                food.setName(cursor.getString(cursor.getColumnIndex("Name")));
                food.setCalories(cursor.getString(cursor.getColumnIndex("Calories")));
                food.setProtein(cursor.getString(cursor.getColumnIndex("Sugar")));
                food.setSugar(cursor.getString(cursor.getColumnIndex("Protein")));
                food.setFat(cursor.getString(cursor.getColumnIndex("Fat")));
                food.setCabor(cursor.getString(cursor.getColumnIndex("Carbohydrates")));


                result.add(food);
            }while (cursor.moveToNext());

        }
        return result;
    }



    public List<String> getName()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"Name"};
        String tablename = "healthyfood";

        qb.setTables(tablename);
        Cursor cursor = qb.query(db,sqlSelect,null,null,null,null,null);
        List<String> result = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {

                result.add(cursor.getString(cursor.getColumnIndex("Name")));
            }while (cursor.moveToNext());

        }
        return result;
    }

    public List<Food> getFoodByName(String name)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String [] sqlSelect = {"id", "Name", "Calories","Sugar", "Protein","Fat","Carbohydrates"};
        String tablename = "healthyfood";

        qb.setTables(tablename);



        Cursor cursor = qb.query(db,sqlSelect,"Name Like ?", new String[]{"%" + name + "%"},null,null,null,null);
        List<Food> result = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                Food food = new Food();
                food.setId(cursor.getInt(cursor.getColumnIndex("id")));
                food.setName(cursor.getString(cursor.getColumnIndex("Name")));
                food.setCalories(cursor.getString(cursor.getColumnIndex("Calories")));
                food.setProtein(cursor.getString(cursor.getColumnIndex("Protein")));
                food.setSugar(cursor.getString(cursor.getColumnIndex("Sugar")));
                food.setFat(cursor.getString(cursor.getColumnIndex("Fat")));
                food.setCabor(cursor.getString(cursor.getColumnIndex("Carbohydrates")));


                result.add(food);
            }while (cursor.moveToNext());

        }
        return result;
    }

}
