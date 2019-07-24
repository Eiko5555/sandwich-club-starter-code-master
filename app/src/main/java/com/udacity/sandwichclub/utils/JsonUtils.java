package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        Sandwich sandwich = new Sandwich();
        JSONObject sandwich_detail = new JSONObject(json);
        JSONObject sandwich_name = sandwich_detail.getJSONObject("name");
        List<String> alsoknownasList = new ArrayList<>();
        List<String> ingredientList = new ArrayList<>();

        JSONArray jsonAknownas = sandwich_name.getJSONArray("alsoKnownAs");
        for (int i=0; i<jsonAknownas.length(); i++){
            alsoknownasList.add(jsonAknownas.getString(i));
        }
        JSONArray jsonAingredientlist = sandwich_detail.getJSONArray("ingredients");
        for (int i=0; i<jsonAingredientlist.length(); i++){
            ingredientList.add(jsonAingredientlist.getString(i));
        }

        sandwich.setMainName(sandwich_name.getString("mainName"));
        sandwich.setAlsoKnownAs(alsoknownasList);
        sandwich.setPlaceOfOrigin(sandwich_detail.getString("placeOfOrigin"));
        sandwich.setDescription(sandwich_detail.getString("description"));
        sandwich.setImage(sandwich_detail.getString("image"));
        sandwich.setIngredients(ingredientList);

        return sandwich;
    }
}
