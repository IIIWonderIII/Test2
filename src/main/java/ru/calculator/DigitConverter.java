package ru.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class DigitConverter {

    private static final TreeMap<Integer, String> map = new TreeMap<>();
    private static final List<String> list = new ArrayList<>();

    static  {
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        list.add("I");
        list.add("II");
        list.add("III");
        list.add("IV");
        list.add("V");
        list.add("VI");
        list.add("VII");
        list.add("VIII");
        list.add("IX");
        list.add("X");
    }

    public static int romanToArabic(String num) {
        if (!list.contains(num)) {
            throw new IllegalArgumentException();
        }

        return list.indexOf(num) + 1;
    }

    public static String arabicToRoman(int num) {
        int l =  map.floorKey(num);
        if ( num == l ) {
            return map.get(num);
        }
        return map.get(l) + arabicToRoman(num-l);
    }

    public static boolean isRomanDigit(String num) {
        return list.contains(num);
    }

}
