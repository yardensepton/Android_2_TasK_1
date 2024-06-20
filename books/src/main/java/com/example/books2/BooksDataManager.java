package com.example.books2;



import android.content.Context;
import android.content.SharedPreferences;

import com.example.common.BaseDataManager;
import com.example.common.Item;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class BooksDataManager extends BaseDataManager {
    ArrayList<Item>books;

    public BooksDataManager() {
        books = new ArrayList<>();

        books.add(new Item("To Kill a Mockingbird", 1,R.drawable.mickingbird , false));
        books.add(new Item("1984", 2, R.drawable.book, false));
        books.add(new Item("The Great Gatsby", 3, R.drawable.greatgatsby, false));
        books.add(new Item("The Catcher in the Rye", 4, R.drawable.catcher, false));
        books.add(new Item("The Hobbit", 5, R.drawable.hobbit, false));
        books.add(new Item("Fahrenheit 451", 6, R.drawable.fer, false));
        books.add(new Item("Moby-Dick", 7, R.drawable.mobby, false));
        books.add(new Item("Pride and Prejudice", 8, R.drawable.pride, false));
        books.add(new Item("Jane Eyre", 9, R.drawable.jane, false));
        books.add(new Item("War and Peace", 10, R.drawable.war, false));
        books.add(new Item("Crime and Punishment", 11, R.drawable.crime, false));
        books.add(new Item("The Odyssey", 12, R.drawable.ody, false));
        books.add(new Item("Brave New World", 13, R.drawable.brace, false));
        books.add(new Item("Harry Potter and the Sorcerer's Stone", 15, R.drawable.harry, false));

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
        return books;
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