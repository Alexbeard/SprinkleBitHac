package com.sprinklebit.mapper;

import com.sprinklebit.model.Slide;

import java.util.List;

public class FileSlideMapper {

    public static String map(List<Slide> slides) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(slides.size()).append("\n");

        for (int i = 0; i < slides.size(); i++) {
            stringBuffer.append(slides.get(i).getId()).append("\n");
        }

        return stringBuffer.toString();
    }
}
