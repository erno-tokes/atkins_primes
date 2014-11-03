package com.test.primes.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import android.text.TextUtils;

public class PrimeFile {
	
	public ArrayList<Integer[]> generateFromFile(String filePath){
		if(TextUtils.isEmpty(filePath))
			return null;
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = br.readLine()) != null) {
			   try{
				   int i = Integer.parseInt(line.trim());
				   values.add(i);
			   }
			   catch(Exception ie){}
			}
		}
		catch(Exception e){}
		finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
		return null;
	}
}
