package com.example.ankit_pc.dietmanager;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by ANKIT_PC on 22-01-2017.
 */
public class NutrientContract {
    public static final String CONTENT_AUTHORITY = "com.example.ankit_pc.dietmanager";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_NUTRIENT = "nutrients";


    public static final class NutrientsEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_NUTRIENT).build();

        // Constant strings to tell the difference between a list of items (CONTENT_TYPE)
        // and a singe item (CONTENT_ITEM_TYPE)

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NUTRIENT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_NUTRIENT;

        public static final String TABLE_NAME = "nutrients";

        public static final String COLUMN_PRODUCT_ID = "product_id";
        public static final String COLUMN_NUTRIENT_UNIT = "nutrient_unit";
        //public static final String COLUMN_NUTRIENT_ID = "nutrient_id";
        public static final String COLUMN_NUTRIENT_NAME = "nutrient_name";
        public static final String COLUMN_NUTRIENT_QUAN = "nutrient_quan";

        /**
         * This method creates a URI for addressing a movie according to its poster URL
         *
         * @param posterUrl The stringly-typed URL fetched from the cloud service
         * @return The URI with the given {@code posterUrl} appended
         */
        public static Uri buildMovieWithPoster(String posterUrl) {
            return CONTENT_URI.buildUpon()
                    .appendPath(posterUrl.substring(1)) //remove the heading slash
                    .build();
        }

        /**
         * Build a Uri for a record of the table, using the ID
         *
         * @param id The ID of the record
         * @return A new Uri with the given ID appended to the end of the path
         */
        public static Uri buildNutrientWithProductId(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        /**
         * This method does the opposite of {@code buildMovieWithPoster}, hence returns the
         * stringly-typed URL
         *
         * @param uri The URI of the movie
         * @return The poster URL fetched from the URI
         */
        //    public static String getPosterUrlFromUri(Uri uri) {
        //     return uri.getPathSegments().get(1);
        //   }
        public static long getIdFromUri(Uri uri) {
            return ContentUris.parseId(uri);
        }


    }

}
