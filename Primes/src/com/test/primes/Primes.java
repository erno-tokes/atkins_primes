package com.test.primes;

import java.util.ArrayList;

public class Primes {
	
	public static final int MAX = 1294967295;
	
	public static Integer[] generate(int limit){
		
		int SQRT_limit = (int) Math.sqrt(limit) + 1;
		boolean[] array = new boolean[limit];
		
		for (int x = 1; x < SQRT_limit; x++) {
			for (int y = 1; y < SQRT_limit; y++) {
				int k = 4 * x * x + y * y;
				if ((k < limit) && ((k % 12 == 1) || (k % 12 == 5))) {
					array[k] = !array[k];
				}
				k = 3 * x * x + y * y;
				if ((k < limit) && (k % 12 == 7)) {
					array[k] = !array[k];
				}
				if (x > y) {
					k = 3 * x * x - y * y;
					if ((k < limit) && (k % 12 == 11)) {
						array[k] = !array[k];
					}
				}
			}
		}
		array[2] = true;
		array[3] = true;
		for (int n = 5; n <= SQRT_limit; n++) {
			if (array[n]) {
				int n2 = n * n;
				for (int k = n2; k < limit; k += n2) {
					array[k] = false;
				}
			}
		}
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int i = 2; i < array.length; i++){
			if(array[i]){
				res.add(i);
			}
		}
		return res.toArray(new Integer[]{});
	}
	
}
