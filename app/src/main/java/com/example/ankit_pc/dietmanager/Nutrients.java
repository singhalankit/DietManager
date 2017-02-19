package com.example.ankit_pc.dietmanager;

/**
 * Created by ANKIT_PC on 27-01-2017.
 */
public class Nutrients {
    private String nutrientName;
    private String nutrientUnit;
    private String nutrientQuantity;

    public Nutrients(String N, String U, String Q) {
        this.nutrientName = N;
        this.nutrientUnit = U;
        this.nutrientQuantity = Q;

    }

    public String getNutrientName() {
        return nutrientName;
    }

    public void setNutrientName(String NutrientName) {
        this.nutrientName = NutrientName;
    }

    public String getNutrientUnit() {
        return nutrientUnit;
    }

    public void setNutrientUnit(String unit) {
        this.nutrientUnit = unit;
    }

    public String getNutrientQuantity() {
        return nutrientQuantity;
    }

    public void setNutrientQuantity(String quantity) {
        this.nutrientQuantity = quantity;
    }
}
