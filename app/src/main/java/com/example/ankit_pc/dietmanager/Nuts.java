package com.example.ankit_pc.dietmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Nuts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuts);
    }

    public void onClickAlmonds(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "12061");
        startActivity(nutrientsIntent);
    }

    public void onClickCashew(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "12087");
        startActivity(nutrientsIntent);
    }

    public void onClickPistachio(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "12151");
        startActivity(nutrientsIntent);
    }

    public void onClickNutsWithoutSalt(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "12138");
        startActivity(nutrientsIntent);
    }


    public void onClickWalnuts(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "12155");
        startActivity(nutrientsIntent);
    }

    public void onClickNutsWithSalt(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "12638");
        startActivity(nutrientsIntent);
    }


}
