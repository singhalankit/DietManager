package com.example.ankit_pc.dietmanager;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANKIT_PC on 27-01-2017.
 */
public class NutrientAdapter extends CursorAdapter {
    Context mContext;

    public NutrientAdapter(Context context, Cursor c, int flags){
        super(context, c, flags);
        mContext=context;
    }

    public static class ViewHolder {

        public final TextView tvName;
        public final TextView tvUnit;
        public final TextView tvQuantity;


        public ViewHolder(View v) {

             tvName = (TextView) v.findViewById(R.id.id_nutrient_name);
             tvUnit = (TextView) v.findViewById(R.id.id_nutrient_unit);
             tvQuantity = (TextView) v.findViewById(R.id.id_nutrient_quantity);

        }
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_show_nutrients, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setTag(viewHolder);

        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = (ViewHolder) view.getTag();
        viewHolder.tvName.setText(cursor.getString(cursor.getColumnIndex(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_NAME)));
        viewHolder.tvQuantity.setText(cursor.getString(cursor.getColumnIndex(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_QUAN)));
        viewHolder.tvUnit.setText(cursor.getString(cursor.getColumnIndex(NutrientContract.NutrientsEntry.COLUMN_NUTRIENT_UNIT)));
    }
    /*private ArrayList<Nutrients> adapterObject;
    public NutrientAdapter(Context context, int resource, ArrayList<Nutrients> objects) {
        super(context, resource, objects);
        this.adapterObject = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.activity_show_nutrients, null);
        }

        Nutrients N = adapterObject.get(position);

        if (N != null){

            TextView tvName = (TextView) v.findViewById(R.id.id_nutrient_name);
            TextView tvUnit = (TextView) v.findViewById(R.id.id_nutrient_unit);
            TextView tvQuantity = (TextView) v.findViewById(R.id.id_nutrient_quantity);


            if(tvName != null)
            {
                tvName.setText(N.getNutrientName());
            }
            if(tvUnit != null)
            {
                tvUnit.setText(N.getNutrientUnit());
            }
            if(tvQuantity != null)
            {
                tvQuantity.setText(N.getNutrientQuantity());
            }

        }


return v;
    }*/
}
