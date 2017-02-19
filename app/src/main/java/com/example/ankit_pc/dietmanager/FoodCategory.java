package com.example.ankit_pc.dietmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FoodCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_categories);
    }

    public void onClickVegetables(View v) {
        Intent vegetablesIntent = new Intent(getApplication(), Vegetables.class);
        startActivity(vegetablesIntent);
    }


    public void onClickFruits(View v) {
        Intent vegetablesIntent = new Intent(getApplication(), Fruits.class);
        startActivity(vegetablesIntent);
    }

    public void onClickNuts(View v) {
        Intent vegetablesIntent = new Intent(getApplication(), Nuts.class);
        startActivity(vegetablesIntent);
    }

    public void onClickBabyFood(View v) {
        Intent vegetablesIntent = new Intent(getApplication(), BabyFoods.class);
        startActivity(vegetablesIntent);
    }

    public void onClickDairy(View v) {
        Intent vegetablesIntent = new Intent(getApplication(), DailryEggProducts.class);
        startActivity(vegetablesIntent);
    }


}
