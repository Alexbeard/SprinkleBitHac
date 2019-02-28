package com.sprinklebit;

import java.util.List;

public class Main {

    private static String PATH_IN = "resources/in/";
    private static String PATH_OUT = "resources/out/";


    public static void main(String[] args) {
        List<String> read = ReaderWriter.read(PATH_IN + "a_example.in");

        for (String s : read) {
            System.out.println(s);
        }

        ReaderWriter.write(read, PATH_OUT + "result.txt");
    }
}
