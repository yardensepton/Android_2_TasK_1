package com.example.common;

import androidx.annotation.NonNull;



public class Item {

    private  String name;

    private  int id;

    private  int img;

    private boolean like;


    public Item(String name, int id, int img, boolean like) {
        this.name = name;
        this.id = id;
        this.img = img;
        this.like = like;
    }
    public Item() {

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setLike() {
        this.like = true;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    @NonNull
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", like=" + like +
                '}';
    }
}
