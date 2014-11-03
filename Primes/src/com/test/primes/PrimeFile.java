package com.test.primes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.test.primes.PrimeGen.PrimeFinishedListener;

import android.text.TextUtils;

public class PrimeFile {
	
	public static void generateFromFile(String filePath, PrimeFinishedListener listener){
		if(TextUtils.isEmpty(filePath))
			return ;
		
		Integer[] limits = getLimitsFromLines(filePath);
		PrimeGen pgen = new PrimeGen(listener);
		pgen.execute(limits);
	}
	
	public static ArrayList<Integer[]> generateFromFile(String filePath){
		if(TextUtils.isEmpty(filePath))
			return null;
		
		Integer[] limits = getLimitsFromLines(filePath);
		PrimeGen pgen = new PrimeGen();
		pgen.execute(limits);
		
		ArrayList<Integer[]> result = null;
		try {
			result = pgen.get();
		} catch (Exception e) {}
		return result;
		
	}
	
	private static Integer[] getLimitsFromLines(String file){
		ArrayList<Integer> values = new ArrayList<Integer>();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
			   try{
				   int i = Integer.parseInt(line.trim());
				   values.add(i);
			   }
			   catch(Exception ie){}
			}
		}
		catch(Exception e){ e.printStackTrace(); }
		finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return values.toArray(new Integer[]{});
	}
}
