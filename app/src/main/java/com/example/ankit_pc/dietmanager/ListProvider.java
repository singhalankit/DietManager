package com.example.ankit_pc.dietmanager;

import android.app.LauncherActivity;
import android.appwidget.AppWidgetManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.widget.ArrayAdapter;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by ANKIT_PC on 19-02-2017.
 */

public class ListProvider implements RemoteViewsService.RemoteViewsFactory {

    private List<Nutrients> widgetNutrientsList = new ArrayList<Nutrients>();
    private ArrayAdapter<Nutrients> widgetAdapter;
    private Context context = null;
    private int appWidgetId;

    public ListProvider(Context context, Intent intent) {
        this.context = context;
        this.appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);

        populateListItem();
    }

    private static final String[] NUTRIENT_COLUMNS = {
            NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_NAME,
            NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_QUAN,
            NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_UNIT
    };


    private void populateListItem() {


        FetchNutrientValuesFragment fnv = new FetchNutrientValuesFragment();
        //Uri nutrientWithProductIdURI = NutrientContract.NutrientsEntry.buildNutrientWithProductId(
        //     Long.parseLong(fnv.mproductID));

        Uri nutrientWithProductIdURI = NutrientContract.NutrientsEntry.CONTENT_URI;
        Cursor data = context.getContentResolver().query(nutrientWithProductIdURI, NUTRIENT_COLUMNS, null,
                null, null);
        Vector<ContentValues> cVVector = new Vector<ContentValues>(data.getCount());
        // cVVector = new Vector<ContentValues>(data.getCount());
        if (data.moveToFirst()) {
            do {
                ContentValues cv = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(data, cv);
                cVVector.add(cv);
            } while (data.moveToNext());
        }

        for (int i = 0; i < cVVector.size(); i++) {
            ContentValues nutrientValues = cVVector.elementAt(i);
            LauncherActivity.ListItem listItem = new LauncherActivity.ListItem();

            Nutrients newNutrient = new Nutrients(nutrientValues.getAsString(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_NAME)
                    , nutrientValues.getAsString(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_UNIT)
                    , nutrientValues.getAsString(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_QUAN));
            widgetNutrientsList.add(i, newNutrient);
        }


    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
        return widgetNutrientsList.size();
    }

    @Override
    public RemoteViews getViewAt(int i) {
        final RemoteViews remoteView = new RemoteViews(
                context.getPackageName(), R.layout.widget_list);
        Nutrients listItem = widgetNutrientsList.get(i);
        remoteView.setTextViewText(R.id.widget_nutrient_name, listItem.getNutrientName());
        remoteView.setTextViewText(R.id.widget_nutrient_unit, listItem.getNutrientUnit());
        remoteView.setTextViewText(R.id.widget_nutrient_quan, listItem.getNutrientQuantity());

        return remoteView;
    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }
}
