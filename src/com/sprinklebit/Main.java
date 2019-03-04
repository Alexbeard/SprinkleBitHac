package com.sprinklebit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> read = ReaderWriter.read("a_example.in");

        int slidesQty = Integer.parseInt(read.get(0));

        ArrayList<Slide> slides = new ArrayList<>();

        for (int i = 1; i < slidesQty + 1; i++) {
            String[] row = read.get(i).split(" ");

            String orientation = row[0];
            int qty = Integer.parseInt(row[1]);

            ArrayList<String> tags = new ArrayList<>();
            for (int j = 2; j < 2+qty; j++) {
                tags.add(row[j]);
            }

            Slide slide = new Slide(i-1, orientation, tags);

            slides.add(slide);
        }

        ArrayList<ArrayList<Slide>> slidesorted = createSlides(slides);

        try {
            ArrayList<String> text = new ArrayList<>();

            text.add((slidesorted.size()) + "");

            for (ArrayList<Slide> sl : slidesorted) {
                String row = "";
                for (Slide s : sl) {
                    row = row + s.getId() + " ";
                }

                text.add(row);
            }

            ReaderWriter.write(text, "result.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<ArrayList<Slide>> createSlides(ArrayList<Slide> slides) {

        ArrayList<ArrayList<Slide>> s = new ArrayList<>();

        int i = 1;

        for ( Slide sl : slides) {

            System.out.println("" + i);

            addToSlides(s, sl, slides);

            i++;


        }



        return s;
    }

    private static void addToSlides(ArrayList<ArrayList<Slide>> s, Slide sl, ArrayList<Slide> slides) {
        if (s.size() == 0) {
            ArrayList<Slide> slideAr = new ArrayList<>();
            if (sl.getOrientaiton().equals("V")) {
                for (int i=slides.indexOf(sl) + 1; i<slides.size(); i++) {
                    if (slides.get(i).getOrientaiton().equals("V")) {
                        slideAr.add(sl);
                        slideAr.add(slides.get(i));
                        slideAr.get(1).setOrientaiton("");
                        break;
                    }
                }
            } else if (sl.getOrientaiton().equals("H")) {
                slideAr.add(sl);
            }

            if (slideAr.size() != 0) {
                s.add(slideAr);
            }
        } else {
            int count = 0;
            int index = 0;
            ArrayList<Slide> slideAr = new ArrayList<>();
            if (sl.getOrientaiton().equals("V")) {
                for (int i=slides.indexOf(sl) + 1; i<slides.size(); i++) {
                    if (slides.get(i).getOrientaiton().equals("V")) {
                        slideAr.add(sl);
                        slideAr.add(slides.get(i));
                        slideAr.get(1).setOrientaiton("");
                        break;
                    }
                }
            } else if (sl.getOrientaiton().equals("H")) {
                slideAr.add(sl);
            }

            if (slideAr.size() != 0) {
                HashSet<String> tag1 = new HashSet<>();

                if (slideAr.size() == 2) {
                    tag1.addAll(slideAr.get(0).getTags());
                    tag1.addAll(slideAr.get(1).getTags());
                } else {
                    tag1.addAll(slideAr.get(0).getTags());
                }

                for (ArrayList<Slide> arSlide : s) {
                    int max = countInterest(count, tag1, arSlide);

                    if (max > count) {
                        count = max;
                        index = s.indexOf(arSlide);
                    } else if (count > tag1.size()/2 - 3) {
                        break;
                    }
                }
            }



            if (slideAr.size() != 0) {
                s.add(index, slideAr);
            }
        }
    }

    private static int countInterest(int count, HashSet<String> tag1, ArrayList<Slide> s) {

        HashSet<String> tag2 = new HashSet<>();

        if (s.size() == 2) {
            tag2.addAll(s.get(0).getTags());
            tag2.addAll(s.get(1).getTags());
        } else {
            tag2.addAll(s.get(0).getTags());
        }

        int countComm = getComm(tag1, tag2);

        int count12 = tag1.size()-countComm;


        int count21 = tag2.size()-countComm;

        int min = getMin(count12, count21, countComm);

        return min;
    }

    private static int getMin(int count12, int count21, int countComm) {
        if (count12 <= count21 && count12 <= countComm) return count12;
        if (count21 <= count12 && count21 <= countComm) return count21;

        return countComm;
    }

    private static int getComm(HashSet<String> tag1, HashSet<String> tag2) {
        int coumt = 0;

        for (String s : tag1) {
            for (String st: tag2) {
                if (s.equals(st)) {
                    coumt++;
                }
            }
        }

        return coumt;
    }

    private static int getNot(HashSet<String> tag1, HashSet<String> tag2) {
        int coumt = 0;

        for (String s : tag1) {
            for (String st: tag2) {
                if (!s.equals(st)) {
                    coumt++;
                }
            }
        }

        return coumt;
    }

    private static Slide findVertical(Slide firstSlide, ArrayList<Slide> slides) {


        for (Slide s: slides) {
            if (s.getOrientaiton() == "V") {
                slides.remove(s);
                return s;
            }
        }

        return null;
    }

    private static Slide getFirstSlide(ArrayList<Slide> slides, ArrayList<ArrayList<Slide>> s) {


        Slide slide = slides.get(slides.size() - 1);
        slides.remove(slide);

        return slide;
    }
}
