package com.example.ankit_pc.dietmanager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ANKIT_PC on 22-01-2017.
 */
    public class NutrientDBHelper extends SQLiteOpenHelper {
    private final String LOG_TAG = NutrientDBHelper.class.getSimpleName();

    private static final int DATABASE_VERSION = 7;

    static final String DATABASE_NAME = "nutrient_info_v1.1.db";

    public NutrientDBHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {



        final String createNutrientsTable = "CREATE TABLE " + NutrientContract.NutrientsEntry.TABLE_NAME + " ( "
                + NutrientContract.NutrientsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NutrientContract.NutrientsEntry.COLUMN_PRODUCT_ID + " INTEGER NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_NAME + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_UNIT + " TEXT NOT NULL, "
                + NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_QUAN + " INTEGER NOT NULL ); ";


                db.execSQL(createNutrientsTable);

        Log.v(LOG_TAG," - Table created successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + NutrientContract.NutrientsEntry.TABLE_NAME);
        onCreate(db);
    }
}
