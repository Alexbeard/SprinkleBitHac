package com.sprinklebit.model;

import java.util.List;

public class Image {

    private int id;
    private Orientation orientation;
    private List<String> tags;

    public Image(int id, Orientation orientation, List<String> tags) {
        this.id = id;
        this.orientation = orientation;
        this.tags = tags;
    }

    public int getId() {
        return id;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public List<String> getTags() {
        return tags;
    }


}
