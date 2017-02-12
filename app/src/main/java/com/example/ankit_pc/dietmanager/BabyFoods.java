package com.example.ankit_pc.dietmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BabyFoods extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_foods);
    }

    public void onClickAppleBananaJuice(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","03167");
        startActivity(nutrientsIntent);
    }


    public void onClickAppleCranberryJuice(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","03169");
        startActivity(nutrientsIntent);
    }

    public void onClickCookies(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","03213");
        startActivity(nutrientsIntent);
    }

    public void onClickMixedFruitJuice(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","03179");
        startActivity(nutrientsIntent);
    }

    public void onClickOrangeJuice(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","03172");
        startActivity(nutrientsIntent);
    }


}
