package com.hepexta.interview.algorithms.sorting;

public class MergeSort {

    private static int traverseCount = 0;

    public static int sort(int[] arr){
        traverseCount = 0;
        mergeSort(arr, arr.length);
        return traverseCount;
    }

    public static void mergeSort(int[] a, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
            traverseCount++;
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
            traverseCount++;
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            traverseCount++;
            if (l[i] < r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }

        while (i < left) {
            traverseCount++;
            a[k++] = l[i++];
        }

        while (j < right) {
            traverseCount++;
            a[k++] = r[j++];
        }
    }
}
