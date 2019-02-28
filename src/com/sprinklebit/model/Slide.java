package com.sprinklebit.model;

import com.sun.istack.internal.Nullable;

public class Slide {
    private Image first;
    private Image second;

    public Slide(Image first, @Nullable Image second) {
        this.first = first;
        this.second = second;
    }

    public Image getFirst() {
        return first;
    }

    public void setFirst(Image first) {
        this.first = first;
    }

    public Image getSecond() {
        return second;
    }

    public void setSecond(Image second) {
        this.second = second;
    }

    public String getSlidePair() {
        if (second != null) {
            return "" + first.getId() + " " + second.getId();
        } else {
            return "" + first.getId();
        }
    }
}
