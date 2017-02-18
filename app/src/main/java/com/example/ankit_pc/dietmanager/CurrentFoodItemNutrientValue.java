package com.example.ankit_pc.dietmanager;

import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.ListView;
import android.widget.RemoteViews;

/**
 * Created by ANKIT_PC on 18-02-2017.
 */
public class CurrentFoodItemNutrientValue extends IntentService

{
    private static final String[] NUTRIENT_COLUMNS = {
            NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_NAME,
            NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_QUAN,
            NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_UNIT
    };

    private static final int INDEX_NUTRIENT_NAME = 0;
    private static final int INDEX_NUTRIENT_QUAN = 1;
    private static final int INDEX_NUTRIENT_UNIT = 2;


    public CurrentFoodItemNutrientValue() {
        super("CurrentFoodItemNutrientValue");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this,
                CurrentNutrientWidgetProvider.class));


        FetchNutrientValuesFragment fnv = new FetchNutrientValuesFragment();
                Uri nutrientWithProductIdURI = NutrientContract.NutrientsEntry.buildNutrientWithProductId(
                Long.parseLong(fnv.mproductID));
        Cursor data = getContentResolver().query(nutrientWithProductIdURI, NUTRIENT_COLUMNS, null,
                null, null);

        for (int appWidgetId : appWidgetIds) {

            RemoteViews views = new RemoteViews(getPackageName(), R.layout.fragment_fetch_nutrient_values);

            NutrientAdapter na = new NutrientAdapter(getApplication(), data, 0);


            Intent launchIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, launchIntent, 0);
            views.setOnClickPendingIntent(R.id.fragmentFetchNutrientValue, pendingIntent);

            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);




        }
    }
}
