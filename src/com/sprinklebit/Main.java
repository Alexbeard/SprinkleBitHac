package com.sprinklebit;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        List<String> read = ReaderWriter.read("a_example.in");

        for (String s : read) {
            System.out.println(s);
        }

        try {
            ReaderWriter.write(read, "result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
