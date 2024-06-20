package com.example.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SwipeAdapter extends BaseAdapter {

    private final ArrayList<Item> items;
    private final Context context;

    public SwipeAdapter(Context context, ArrayList<Item> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.swipe_item, parent, false);
        }

        ImageView imageView = view.findViewById(R.id.item_image);
        TextView textView = view.findViewById(R.id.item_name);

        Item item = items.get(position);
        textView.setText(item.getName());

        Glide.with(context).load(item.getImg()).into(imageView);

        return view;
    }
}
