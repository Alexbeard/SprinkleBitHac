package com.sprinklebit;

import java.util.ArrayList;

public class Slide {
    private int id;
    private String orientaiton;
    private ArrayList<String> tags = new ArrayList<>();

    public Slide(int id, String orientaiton, ArrayList<String> tags) {
        this.id = id;
        this.orientaiton = orientaiton;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrientaiton() {
        return orientaiton;
    }

    public void setOrientaiton(String orientaiton) {
        this.orientaiton = orientaiton;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
