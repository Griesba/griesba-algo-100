package com.leretvil.quicksort;

import java.lang.reflect.Array;

public class QuickSort <T extends Comparable <T>> {

    private T[] array;
    private int N;

    public QuickSort(Class<T[]> clazz, int N){
        this.array = clazz.cast(Array.newInstance(clazz.getComponentType(), N));
        this.N = N;
    }

    public QuickSort() {
    }

    private int choiceOfPivotWithMedianOfThree (T[] array, int lo, int hi) {
        // https://en.wikipedia.org/wiki/Quicksort#Choice_of_pivot
        int pivot = (lo + hi)/2;
        if(array[lo].compareTo(array[pivot]) > 0) {
            swap(array, lo, pivot);
        }
        if (array[lo].compareTo(array[hi]) > 0 ) {
            swap(array, lo, hi);
        }
        if (array[pivot].compareTo(array[hi]) > 0) {
            swap(array, pivot, hi);
        }
        return pivot;
    }

    private   void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public  T[] sort(T[] array, int lo, int hi) {
        if( lo < hi) {
            int pivot = partition(array, lo, hi);
            sort(array, lo, pivot);
            sort(array, pivot + 1, hi);
        }
        return array;
    }

    private   int partition (T [] array, int lo, int hi) {
        int pivot = choiceOfPivotWithMedianOfThree(array, lo, hi);
        int i = lo;
        int j = hi;
        while(true) {
            while(array[i].compareTo(array[pivot]) < 0) {
                i++;
            }
            while(array[j].compareTo(array[pivot]) > 0) {
                j--;
            }
            if (i >= j) {
                return j;
            }
            swap(array, i, j);
        }

    }

}
