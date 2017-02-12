package com.example.ankit_pc.dietmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ANKIT_PC on 22-01-2017.
 */
    public class NutrientDBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;

    static final String DATABASE_NAME = "nutrient_info.db";

    public NutrientDBHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {



        final String createNutrientsTable = "CREATE TABLE " + NutrientContract.NutrientsEntry.TABLE_NAME + " ( "
                + NutrientContract.NutrientsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NutrientContract.NutrientsEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT1_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT1_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT1_QUAN + " INTEGER NOT NULL ); ";
               /* + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT2_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT2_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT2_QUAN + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT3_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT3_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT3_QUAN + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT4_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT4_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT4_QUAN + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT5_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT5_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT5_QUAN + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT6_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT6_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT6_QUAN + " INTEGER NOT NULL);";*/

                db.execSQL(createNutrientsTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + NutrientContract.NutrientsEntry.TABLE_NAME);
        onCreate(db);
    }
}
