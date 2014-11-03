package com.test.primes;

import java.util.ArrayList;

import android.os.AsyncTask;

public class PrimeGen extends AsyncTask<Integer, Void, ArrayList<Integer[]>>{

	public interface PrimeFinishedListener{
		public void onFinish(ArrayList<Integer[]> results);
	}
	
	private PrimeFinishedListener listener;
	
	public PrimeGen(){
		
	}
	
	public PrimeGen(PrimeFinishedListener listener){
		this.listener = listener;
	}
	
	@Override
	protected ArrayList<Integer[]> doInBackground(Integer... args) {
		if(args == null || args.length == 0)
			return null;
		
		ArrayList<Integer[]> res = new ArrayList<Integer[]>();
		for(Integer i : args){
			res.add(Primes.generate(i));
		}
		
		return res;
	}
	
	@Override
	public void onPostExecute(ArrayList<Integer[]> result){
		if(listener != null){
			listener.onFinish(result);
		}
	}
}
