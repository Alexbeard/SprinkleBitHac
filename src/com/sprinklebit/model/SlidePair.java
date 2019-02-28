package com.sprinklebit.model;

import javafx.util.Pair;

public class SlidePair {
    private Slide first;
    private Slide second;

    public SlidePair(Slide first, Slide second) {
        this.first = first;
        this.second = second;
    }

    public String getSlidePair() {
        return "" + first.getId() + " " + second.getId() ;
    }
}
