package com.example.common;

import android.content.Context;

import java.util.ArrayList;

public abstract class BaseDataManager {

    public abstract ArrayList<Item> getLikedItems(String SharedPreferenceName,Context context);

    public abstract ArrayList<Item> getItems();

    public abstract void likeAndSaveItem(String SharedPreferenceName, Item item, Context context);


}
