package com.example.ankit_pc.dietmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANKIT_PC on 27-01-2017.
 */
public class NutrientAdapter extends ArrayAdapter<Nutrients> {
    private ArrayList<Nutrients> adapterObject;
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
    }
}
