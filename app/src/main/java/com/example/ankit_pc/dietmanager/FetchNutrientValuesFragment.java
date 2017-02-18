package com.example.ankit_pc.dietmanager;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A placeholder fragment containing a simple view.
 */
public class FetchNutrientValuesFragment extends Fragment implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {
    private NutrientAdapter mNutrientsAdapter;
    private static final int NUTIRENT_LOADER = 0;
    private final String LOG_TAG = FetchNutrientValuesFragment.class.getSimpleName();
    Intent nutrientsIntent = getActivity().getIntent();
    String mproductID = nutrientsIntent.getStringExtra("Product ID");

    public FetchNutrientValuesFragment() {

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        getLoaderManager().initLoader(NUTIRENT_LOADER, null, this);
        super.onActivityCreated(savedInstanceState);
        getNutrientsData();

    }

    public void getNutrientsData()
    {
        Intent nutrientsIntent = getActivity().getIntent();
        String productID = nutrientsIntent.getStringExtra("Product ID");
        formAPIURL fau = new formAPIURL(getContext(),mNutrientsAdapter);
        fau.execute(productID);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =  inflater.inflate(R.layout.fragment_fetch_nutrient_values, container, false);

     /*   mNutrientsAdapter = new NutrientAdapter(
                getActivity(),
                R.layout.activity_show_nutrients,
                new ArrayList<Nutrients>()
        );*/
        mNutrientsAdapter = new NutrientAdapter(getActivity(),null,0);

        ListView lstView;
        lstView = (ListView) rootView.findViewById(R.id.id_nutrients_listView);

        lstView.setAdapter(mNutrientsAdapter);

        return  rootView;
    }

    @Override
    public android.support.v4.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.v(LOG_TAG,"Entered into Cursor loader");

        Intent nutrientsIntent = getActivity().getIntent();
        String productID = nutrientsIntent.getStringExtra("Product ID");
        Uri nutrientWithProductIdURI = NutrientContract.NutrientsEntry.buildNutrientWithProductId(
                Long.parseLong(productID));
        return new android.support.v4.content.CursorLoader(getActivity(),nutrientWithProductIdURI,null,null,null,null);
    }

    @Override
    public void onLoadFinished(android.support.v4.content.Loader<Cursor> loader, Cursor data) {
    mNutrientsAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.support.v4.content.Loader<Cursor> loader) {

    }


    public class formAPIURL extends AsyncTask<String,Void,Cursor> {
        private final String LOG_TAG = formAPIURL.class.getSimpleName();
        String expectedFormat= "json";
        String nutrientType = "b";
        String apiID = "D21j3zXmboWioyWvMWLZUAlIY179gJLDqJolBqsu";
        private final Context mContext;

        public formAPIURL(Context context,NutrientAdapter nutrientsAdapter)
        {
            mContext = context;
            mNutrientsAdapter = nutrientsAdapter;
        }

        @Override
        protected Cursor doInBackground(String... params) {



        HttpURLConnection urlConnection = null;
            BufferedReader reader = null;


            String nutrientsJsonStr = null;



            try {

                final String BaseURL = "http://api.nal.usda.gov/ndb/reports/?";

                final String PRODUCTID = "ndbno";
                final String TYPE = "type";
                final String FORMAT = "format";
                final String APIKEY = "api_key";
                final String productID= params[0];

                Uri builtUri = Uri.parse(BaseURL).buildUpon()
                        .appendQueryParameter(PRODUCTID, productID)
                        .appendQueryParameter(TYPE, nutrientType)
                        .appendQueryParameter(FORMAT, expectedFormat)
                        .appendQueryParameter(APIKEY, apiID)
                        .build();

                URL url = null;

                url = new URL(builtUri.toString());

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                if (inputStream == null) {
                    //Log.v(LOG_TAG, "String buffer is null");
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }
                //Log.v(LOG_TAG, "String buffer is not null" +buffer.toString() );
                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                    //Log.v(LOG_TAG, "String buffer is null");

                }
                nutrientsJsonStr = buffer.toString();
                Log.v(LOG_TAG, "JSONString initial" + nutrientsJsonStr);


            } catch (IOException e) {
                Log.e(LOG_TAG, "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in attempting
                // to parse it.
                return null;
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }


            //calling method to get data from JSON string
            try {
                //forecastJsonStr_1 = getweatherDataFromJson(forecastJsonStr, 7);
                return getNutrientValuesFromJson(nutrientsJsonStr);
                //Log.v(LOG_TAG,""+forecastJsonStr_1);
            } catch (JSONException e) {
                e.printStackTrace();
            }



        Log.v(LOG_TAG, "JSONString" + nutrientsJsonStr);
            return null;
        }




        private Cursor getNutrientValuesFromJson(String nutrientJsonStr) throws JSONException {

            // Items to extract
            final String ARRAY_OF_NUTRIENTS = "nutrients";
            final String ORIGINAL_ID = "nutrient_id";
            final String NUTRIENT_NAME = "name";
            final String NUTRIENT_QUANTITY = "value";
            final String NUTRIENT_UNIT = "unit";
            try {
                JSONObject nutrientsJson = new JSONObject(nutrientJsonStr);
                JSONObject reportsObject = nutrientsJson.getJSONObject("report");
                JSONObject foodsObject  = reportsObject.getJSONObject("food");
                long productID = foodsObject.getInt("ndbno");
                JSONArray nutrientsArray = foodsObject.getJSONArray(ARRAY_OF_NUTRIENTS);
                int nutrientsLength = nutrientsArray.length();
                Log.v(LOG_TAG,"Nutrients array length" + nutrientsLength);
                //List<MovieParse> movies = new ArrayList<MovieParse>();
                //String[] PosterArray = new String[100];
                List<Nutrients> nutrientsList = new ArrayList<Nutrients>() ;

                Vector<ContentValues> cVVector = new Vector<ContentValues>(nutrientsLength);

                for (int i = 0; i < nutrientsLength; ++i) {

                    JSONObject nutrient = nutrientsArray.getJSONObject(i);
                    //int nutrientID = nutrient.getInt(ORIGINAL_ID);
                    String title = nutrient.getString(NUTRIENT_NAME);
                    String quantity = nutrient.getString(NUTRIENT_QUANTITY);
                    String unit = nutrient.getString(NUTRIENT_UNIT);
                    Log.v(LOG_TAG, "Nutrient Name" + title);

                    ContentValues nutrientValues = new ContentValues();


                    nutrientValues.put("nutrient_unit",unit);
                    nutrientValues.put("nutrient_name",title);
                    nutrientValues.put("nutrient_quan", quantity);
                    nutrientValues.put("product_id",productID);



                    cVVector.add(nutrientValues);

                }
                int inserted = 0;
                Uri nutrientWithProductIdURI = NutrientContract.NutrientsEntry.buildNutrientWithProductId(
                        productID);



                Cursor cur = mContext.getContentResolver().query(nutrientWithProductIdURI,
                        null, null, null, null);

                if (cur.getCount() == 0) {

                    // add to database
                    if (cVVector.size() > 0) {
                        // Student: call bulkInsert to add the weatherEntries to the database here
                        ContentValues[] contentValues = new ContentValues[cVVector.size()];
                        cVVector.toArray(contentValues);
                        inserted = mContext.getContentResolver().bulkInsert(NutrientContract.NutrientsEntry.CONTENT_URI, contentValues);
                    }
                    Log.v(LOG_TAG, "FetchNutrientsTask Complete. " + inserted + " Inserted");

                }


                 cur = mContext.getContentResolver().query(nutrientWithProductIdURI,
                        null, null, null, null);
               // mNutrientsAdapter.changeCursor(cur);


                    cVVector = new Vector<ContentValues>(cur.getCount());
                    if (cur.moveToFirst()) {
                        do {
                            ContentValues cv = new ContentValues();
                            DatabaseUtils.cursorRowToContentValues(cur, cv);
                            cVVector.add(cv);
                        } while (cur.moveToNext());
                    }

                    Log.v(LOG_TAG, "FetchNutrientsTask Complete. " + cVVector.size() + " Inserted");


                    for (int i = 0; i < cVVector.size(); i++) {
                        ContentValues nutrientValues = cVVector.elementAt(i);
                        Nutrients newNutrient = new Nutrients(nutrientValues.getAsString(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_NAME)
                                , nutrientValues.getAsString(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_UNIT)
                                , nutrientValues.getAsString(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_QUAN));
                        nutrientsList.add(i, newNutrient);
                    }


                //Nutrients newNutrient = new Nutrients(title,unit,quantity);
                // nutrientsList.add(i,newNutrient);

                return  cur;




            } catch (JSONException e) {
                Log.e(LOG_TAG, e.getMessage(), e);
                e.printStackTrace();
            }
            return null;
        }


      @Override
        protected void onPostExecute(Cursor c) {
            //    super.onPostExecute(strings);
            if(c != null ){
                mNutrientsAdapter.changeCursor(c);
                }
            }


    }
}
