package com.sprinklebit;

import com.sprinklebit.mapper.FileSlideMapper;
import com.sprinklebit.mapper.SlideMapper;
import com.sprinklebit.model.Image;
import com.sprinklebit.model.Orientation;
import com.sprinklebit.model.Slide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> read = ReaderWriter.read("a_example.txt");
        int countSlides = Integer.parseInt(read.get(0));

        List<Image> slides = new ArrayList<>();

        for (int i = 1; i < countSlides; i++) {
            slides.add(SlideMapper.map(i - 1, read.get(i)));
        }

//        List<Slide> result = calculate(slides);
        List<Slide> result = calculate2(slides);

        for (Image s : slides) {
            System.out.println(s);
        }

        try {
            ReaderWriter.write(FileSlideMapper.map(slides), "result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Slide> calculate(List<Image> images) {
        ArrayList<Slide> slides = new ArrayList<>();

        ArrayList<Image> verticalImages = new ArrayList<>();
        ArrayList<Image> horizontalImages = new ArrayList<>();
        images.forEach(image -> {
            if (image.getOrientation() == Orientation.Vertical) {
                verticalImages.add(image);
            } else  {
                horizontalImages.add(image);
            }
        });

        horizontalImages.forEach(image -> {
            slides.add(new Slide(image, null));
        });

        final Slide[] slide = {null};
        verticalImages.forEach(image -> {
            if (slide[0] == null) {
                slide[0] = new Slide(image, null);
            }else  {
                slide[0].setSecond(image);
                slides.add(slide[0]);
            }
        });

        return slides;
    }

    private static List<Slide> calculate2(List<Image> images) {
        ArrayList<Slide> slides = new ArrayList<>();

        ArrayList<Image> verticalImages = new ArrayList<>();
        ArrayList<Image> horizontalImages = new ArrayList<>();
        images.forEach(image -> {
            if (image.getOrientation() == Orientation.Vertical) {
                verticalImages.add(image);
            } else  {
                horizontalImages.add(image);
            }
        });


        return slides;
    }
}
