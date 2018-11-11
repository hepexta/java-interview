package com.hepexta.interview;

public class MergeSortedArrays {

	public static Integer[] sort(Integer[] arr1, Integer[] arr2){



		int i = 0;
		int j = 0;
		int k = 0;

		int length1 = arr1.length;
		int length2 = arr2.length;
		int finalLength = length1 + length2;
		Integer[] result = new Integer[finalLength];

		while (i<length1 && j<length2){
			if (arr1[i]<arr2[j]){
				result[k++] = arr1[i++];
			}
			else {
				result[k++] = arr2[j++];
			}
		}

		while (i<length1){
			result[k++] = arr1[i++];
		}
		while (j<length2){
			result[k++] = arr2[j++];
		}

		return result;
	}
}
