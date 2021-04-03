package com.leretvil.quicksort;

import org.junit.Test;

public class QuickSortTest {

    @Test
    public void test(){
        String pattern = "abcdre";

        QuickSort<Character> quickSort = new QuickSort<>();

        Character[] res = quickSort.sort(pattern.chars().mapToObj(x -> (char)x).toArray(Character[]::new), 0, pattern.length());

    }
}
