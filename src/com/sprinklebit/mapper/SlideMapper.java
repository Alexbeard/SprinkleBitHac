package com.sprinklebit.mapper;

import com.sprinklebit.model.Orientation;
import com.sprinklebit.model.Slide;

import java.util.ArrayList;
import java.util.Arrays;

public class SlideMapper {

    public static Slide map(int number, String slideDescription) {
        String[] characteristic = slideDescription.split(" ");

        Orientation orientation = Orientation.Vertical;
        if (characteristic[0].equals("H")) {
            orientation = Orientation.Horizontal;
        }

        ArrayList<String> tags = new ArrayList<>(Arrays.asList(characteristic).subList(2, characteristic.length));

        return new Slide(number, orientation, tags);
    }
}
