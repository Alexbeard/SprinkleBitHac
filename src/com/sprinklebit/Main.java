package com.sprinklebit;

import com.sprinklebit.mapper.FileSlideMapper;
import com.sprinklebit.mapper.SlideMapper;
import com.sprinklebit.model.Slide;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<String> read = ReaderWriter.read("a_example.txt");
        int countSlides = Integer.parseInt(read.get(0));

        List<Slide> slides = new ArrayList<>();

        for (int i = 1; i < countSlides; i++) {
            slides.add(SlideMapper.map(i - 1, read.get(i)));
        }

        for (Slide s : slides) {
            System.out.println(s);
        }

        try {
            ReaderWriter.write(FileSlideMapper.map(slides), "result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
