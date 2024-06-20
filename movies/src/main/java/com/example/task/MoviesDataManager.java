package com.example.task;


import android.content.Context;
import android.content.SharedPreferences;


import com.example.common.BaseDataManager;
import com.example.common.Item;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class MoviesDataManager extends BaseDataManager {
    ArrayList<Item>movies;

    public MoviesDataManager() {
        movies = new ArrayList<>();

        movies.add(new Item("Inception", 1, R.drawable.inception, false));
        movies.add(new Item("The Shawshank Redemption", 2, R.drawable.theshawshankredemption, false));
        movies.add(new Item("The Dark Knight", 3, R.drawable.darkknight, false));
        movies.add(new Item("Pulp Fiction", 4,  R.drawable.pulpfiction, false));
        movies.add(new Item("Fight Club", 5,  R.drawable.fightclub, false));
        movies.add(new Item("Forrest Gump", 6,  R.drawable.forrestgump, false));
        movies.add(new Item("The Matrix", 7, R.drawable.matrix, false));
        movies.add(new Item("Goodfellas", 8, R.drawable.goodfellas, false));
        movies.add(new Item("He's not that into you", 9, R.drawable.notintoyou, false));
        movies.add(new Item("The Godfather", 10, R.drawable.godfather, false));
        movies.add(new Item("Titanic", 11, R.drawable.titanic, false));
        movies.add(new Item("Dune", 12, R.drawable.dune, false));
        movies.add(new Item("Spiderman", 13, R.drawable.spiderman, false));
        movies.add(new Item("The notebook", 14, R.drawable.thenotebook, false));

    }

    @Override
    public ArrayList<Item> getLikedItems(String SharedPreferenceName, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferenceName, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        Map<String, ?> allObj = sharedPreferences.getAll();
        ArrayList<Item> likedItems = new ArrayList<>();

        for (Map.Entry<String, ?> entry : allObj.entrySet()) {
            String json = (String) entry.getValue();
            Item item = gson.fromJson(json, Item.class);
            likedItems.add(item);
        }

        return likedItems;
    }

    @Override
    public ArrayList<Item> getItems() {
        return movies;
    }


    @Override
    public void likeAndSaveItem(String SharedPreferenceName, Item item, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(item);
        editor.putString(String.valueOf(item.getId()), json);
        editor.apply();
    }
}
