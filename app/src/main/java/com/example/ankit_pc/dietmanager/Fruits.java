package com.example.ankit_pc.dietmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Fruits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
    }

    public void onClickApples(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09003");
        startActivity(nutrientsIntent);
    }

    public void onClickAppricots(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09021");
        startActivity(nutrientsIntent);
    }

    public void onClickAvacado(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09037");
        startActivity(nutrientsIntent);
    }

    public void onClickBananas(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09040");
        startActivity(nutrientsIntent);
    }

    public void onClickBlackBerries(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09042");
        startActivity(nutrientsIntent);
    }

    public void onClickBlueBerries(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09050");
        startActivity(nutrientsIntent);
    }

    public void onClickCherries(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09070");
        startActivity(nutrientsIntent);
    }

    public void onClickGrapes(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09129");
        startActivity(nutrientsIntent);
    }

    public void onClickMangoes(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09176");
        startActivity(nutrientsIntent);
    }

    public void onClickOrange(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09205");
        startActivity(nutrientsIntent);
    }

    public void onClickPears(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09252");
        startActivity(nutrientsIntent);
    }

    public void onClickPineApples(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09266");
        startActivity(nutrientsIntent);
    }

    public void onClickPlums(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09279");
        startActivity(nutrientsIntent);
    }

    public void onClickStrawBerries(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "09316");
        startActivity(nutrientsIntent);
    }

}
