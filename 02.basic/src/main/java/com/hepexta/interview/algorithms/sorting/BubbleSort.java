package com.hepexta.interview.algorithms.sorting;

public class BubbleSort {

    /*
     * In bubble sort algorithm, array is traversed from first element to last element.
     * Here, current element is compared with the next element.
     * If current element is greater than the next element, it is swapped.
     * Bubble sort has a worst-case and average complexity of О((n^2)/2)
     * */
    public int sort(int[] arr) {
        int n = arr.length;
        int traverseCount = 0;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    traverseCount++;
                }
            }
        }
        return traverseCount;
    }

}
