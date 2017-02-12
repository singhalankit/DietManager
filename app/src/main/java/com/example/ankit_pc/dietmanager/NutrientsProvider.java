package com.example.ankit_pc.dietmanager;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by ANKIT_PC on 22-01-2017.
 */
public class NutrientsProvider extends ContentProvider {

    public static final String LOG_TAG = NutrientsProvider.class.getSimpleName();
    public static final UriMatcher sUriMatcher = createUriMatcher();
    private NutrientDBHelper mOpenHelper;

    static final int NUTRIENTS_WITH_PRODUCT_ID =100;



    public static UriMatcher createUriMatcher() {
        UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
        String authority = NutrientContract.CONTENT_AUTHORITY;
        matcher.addURI(authority, NutrientContract.PATH_NUTRIENT + "/#", NUTRIENTS_WITH_PRODUCT_ID);

        return matcher;
    }



    @Override
    public boolean onCreate() {
        mOpenHelper = new NutrientDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String sort) {
        SQLiteDatabase db = mOpenHelper.getReadableDatabase();

        int match = sUriMatcher.match(uri);
        Cursor cursor;



        switch (match) {




            case NUTRIENTS_WITH_PRODUCT_ID: {
                long _id = NutrientContract.NutrientsEntry.getIdFromUri(uri);
                cursor = db.query(
                        NutrientContract.NutrientsEntry.TABLE_NAME,
                        strings,
                        NutrientContract.NutrientsEntry._ID + " = ?",
                        new String[]{Long.toString(_id)},
                        null,
                        null,
                        null);
                break;
            }



            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }


        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);

        switch (match) {

            case NUTRIENTS_WITH_PRODUCT_ID:
                return NutrientContract.NutrientsEntry.CONTENT_ITEM_TYPE;



            default:
                throw new UnsupportedOperationException("Unknown uri: " + uri);
        }    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase db = mOpenHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        Uri insertionUri;
        int Count =0;

        long insertedId;

        switch (match) {
            case NUTRIENTS_WITH_PRODUCT_ID:
                insertedId = db.insert(NutrientContract.NutrientsEntry.TABLE_NAME, null, values);
                if (insertedId > 0) {
                    insertionUri = NutrientContract.NutrientsEntry.buildNutrientWithProductId(insertedId);
                    Count++;
                } else {
                    throw new SQLException("Failed to insert row into " + uri);
                }
                break;


            default:
                throw new UnsupportedOperationException("Unknown uri " + uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return insertionUri;    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;
    }
}
