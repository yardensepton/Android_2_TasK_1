package com.example.books2;

import android.os.Bundle;

import com.example.common.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManager = new BooksDataManager();
        SharedPreferenceName = "Books";
        name = "Books";
        super.onCreate(savedInstanceState);
    }
}