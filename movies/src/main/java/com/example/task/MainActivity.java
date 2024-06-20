package com.example.task;

import android.os.Bundle;

import com.example.common.BaseActivity;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataManager = new MoviesDataManager();
        SharedPreferenceName = "Movies";
        name = "Movies";
        super.onCreate(savedInstanceState);
    }
}