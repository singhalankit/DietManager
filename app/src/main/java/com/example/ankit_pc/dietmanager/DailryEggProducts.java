package com.example.ankit_pc.dietmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DailryEggProducts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailry_egg_products);
    }

    public void onClickSaltedButter(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01001");
        startActivity(nutrientsIntent);
    }

    public void onClickButterWithoutSalt(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01145");
        startActivity(nutrientsIntent);
    }

    public void onClickEggWhite(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01124");
        startActivity(nutrientsIntent);
    }

    public void onClickEggYolk(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01137");
        startActivity(nutrientsIntent);
    }

    public void onClickSundaeCone(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01301");
        startActivity(nutrientsIntent);
    }

    public void onClickSoftServe(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01236");
        startActivity(nutrientsIntent);
    }

    public void onClickYogurtVannila(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01295");
        startActivity(nutrientsIntent);
    }

    public void onClickMilkBuffalo(View v) {
        Intent nutrientsIntent = new Intent(getApplication(), FetchNutrientValues.class);
        nutrientsIntent.putExtra("Product ID", "01108");
        startActivity(nutrientsIntent);
    }
}
