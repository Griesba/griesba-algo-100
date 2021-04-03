package com.leretvil.anagram;

import com.leretvil.quicksort.QuickSort;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {

        String pattern = "abcder";

        Arrays.asList(pattern.toCharArray());
        QuickSort qs = new QuickSort(Character.class.getClass(), pattern.length());
        qs.sort(pattern.chars().mapToObj(c -> (char)c).toArray(Character[]::new), 0, pattern.length());

    }
}
