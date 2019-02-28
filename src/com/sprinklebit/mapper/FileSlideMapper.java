package com.sprinklebit.mapper;

import com.sprinklebit.model.BaseSlide;
import com.sprinklebit.model.Slide;
import com.sprinklebit.model.SlidePair;

import java.util.List;

public class FileSlideMapper {

    public static String map(List<BaseSlide> slides) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(slides.size()).append("\n");


        for (int i = 0; i < slides.size(); i++) {
            if (slides.get(i) instanceof Slide) {
                stringBuffer.append(((Slide) slides.get(i)).getId()).append("\n");
            } else if (slides.get(i) instanceof SlidePair) {
                stringBuffer.append(((SlidePair) slides.get(i)).getSlidePair()).append("\n");
            }
        }

        return stringBuffer.toString();
    }
}
