package com.test.primes.utils;

import java.util.ArrayList;

import android.os.AsyncTask;

public class PrimeGen extends AsyncTask<Integer, Void, ArrayList<Integer[]>>{

	@Override
	protected ArrayList<Integer[]> doInBackground(Integer... args) {
		if(args == null || args.length == 0)
			return null;
		
		for(Integer i : args){
			Primes.generate(i);
		}
		
		return null;
	}
	
	@Override
	public void onPostExecute(ArrayList<Integer[]> result){
	}
}
