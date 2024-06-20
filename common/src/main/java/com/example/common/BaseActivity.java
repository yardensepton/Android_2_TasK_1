package com.example.common;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;


public class BaseActivity extends AppCompatActivity {

    protected String SharedPreferenceName;
    protected BaseDataManager dataManager;
    protected String name;
    private TextView appName;
    SwipeFlingAdapterView swipeFlingAdapterView;
    private SwipeAdapter adapter;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        initViews();
        swiper();

    }

    void initViews() {
        appName = findViewById(R.id.app_name);
        swipeFlingAdapterView = findViewById(R.id.swipe);
        appName.setText(name);
        items = dataManager.getItems();
        adapter = new SwipeAdapter(this, items);
        swipeFlingAdapterView.setAdapter(adapter);
    }

    void swiper() {
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                if (items.size() > 1) {
                    Item firstItem = items.get(0);
                    items.remove(0);
                    items.add(firstItem);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onLeftCardExit(Object dataObject) {
                Toast.makeText(BaseActivity.this, "DISLIKE!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object dataObject) {
                Toast.makeText(BaseActivity.this, "LIKE!", Toast.LENGTH_SHORT).show();
                Item item = (Item) dataObject;
                item.setLike();
                dataManager.likeAndSaveItem(SharedPreferenceName, item, BaseActivity.this);
                items.remove(item);
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }
        });
    }
}


