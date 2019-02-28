package com.sprinklebit;

import com.sprinklebit.mapper.FileSlideMapper;
import com.sprinklebit.mapper.SlideMapper;
import com.sprinklebit.model.BaseSlide;
import com.sprinklebit.model.Orientation;
import com.sprinklebit.model.Slide;
import com.sprinklebit.model.SlidePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<String> read = ReaderWriter.read("a_example.txt");
        int countSlides = Integer.parseInt(read.get(0));

        List<Slide> slides = new ArrayList<>();
        List<Slide> horizontalSlides = new ArrayList<>();
        List<Slide> verticalSlides = new ArrayList<>();

        for (int i = 1; i <= countSlides; i++) {
            slides.add(SlideMapper.map(i - 1, read.get(i)));
        }

        for (Slide s : slides) {
            if (s.getOrientation() == Orientation.Horizontal ){
                horizontalSlides.add(s);
            }else {
                verticalSlides.add(s);
            }
        }

        Slide first = verticalSlides.get(0);
        Slide second = verticalSlides.get(1);

        SlidePair slidePair = new SlidePair(first, second);

        List<BaseSlide> results = new ArrayList<>(horizontalSlides);
        results.add(slidePair);

        try {
            ReaderWriter.write(FileSlideMapper.map(results), "result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
