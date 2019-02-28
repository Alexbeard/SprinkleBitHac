package com.sprinklebit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReaderWriter {

    public static List<String> read(String fileName) {
        File file = new File(fileName);
        List<String> list = new ArrayList<>();
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                list.add(i);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            list = Collections.emptyList();
        }
        return list;
    }


    public static void write(List<String> result, String fileName) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            for (String s : result) {
                writer.println(s);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

}
