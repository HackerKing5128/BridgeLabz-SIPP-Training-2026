// frequency of array without hashmap

import java.util.*;

class Frequency {
	public static void main(String[] args) {
		int[] arr = {1,2, 3, 5, 7, 2};
		
		// find max element from array
		int max = arr[0];
		for (int i : arr) {
			if (i > max) max = i;
		}
		
		// initialise freq array 
		int[] freq = new int[max + 1];
		for (int i : arr) {
			freq[i]++;
		}
		
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                System.out.println(i + " : " + freq[i]);
            }
        }
	}
}