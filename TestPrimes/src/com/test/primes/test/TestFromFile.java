package com.test.primes.test;

import java.util.ArrayList;

import com.test.primes.PrimeFile;

import junit.framework.TestCase;

public class TestFromFile extends TestCase {

	Integer[] lastResult;
	
	protected void setUp() throws Exception {
		super.setUp();
		lastResult = new Integer[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53};
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testFromFile(){
		ArrayList<Integer[]> result = PrimeFile.generateFromFile("/storage/emulated/0/data/primes.txt");
		assertNotNull(result);
		
		Integer[] last = result.get(result.size() - 1);
		assertEquals(last.length, lastResult.length);
		
		for(int i = 0; i < last.length; i++){
			assertEquals(last[i], lastResult[i]);
		}
	}
}
