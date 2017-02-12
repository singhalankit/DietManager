package com.example.ankit_pc.dietmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Vegetables extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

    }

    public void onClickPotatoes(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11362");
        startActivity(nutrientsIntent);
    }

    public void onClickBrocolli(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11090");
        startActivity(nutrientsIntent);
    }

    public void onClickCabbage(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11109");
        startActivity(nutrientsIntent);
    }
    public void onClickCarrots(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11124");
        startActivity(nutrientsIntent);
    }

    public void onClickCauli(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11135");
        startActivity(nutrientsIntent);
    }

    public void onClickSCorn(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11167");
        startActivity(nutrientsIntent);
    }

    public void onClickCucumber(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11205");
        startActivity(nutrientsIntent);
    }


    public void onClickEggplant(View v)
    {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID","11209");
        startActivity(nutrientsIntent);
    }

}
