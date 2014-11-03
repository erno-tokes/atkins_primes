package com.test.primes.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.test.primes.PrimeFile;
import com.test.primes.PrimeGen;
import com.test.primes.PrimeGen.PrimeFinishedListener;
import com.test.primes.R;

public class PrimesActivity extends ActionBarActivity {

	private static final int CHOOSE_RESULT_CODE = 35264;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primes);
		
		((Button)findViewById(R.id.fileButton)).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("file/*");
				startActivityForResult(intent, CHOOSE_RESULT_CODE);
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode == CHOOSE_RESULT_CODE && resultCode == Activity.RESULT_OK){
			processFile(data.getData().getPath());
			
			findViewById(R.id.progress).setVisibility(View.VISIBLE);
			((TextView)findViewById(R.id.text)).setText("");
		}
	}
	
	public void processFile(final String path){
		PrimeFile.generateFromFile(path, new PrimeFinishedListener(){
			@Override
			public void onFinish(ArrayList<Integer[]> results) {
				TextView text = (TextView)findViewById(R.id.text);
				if(results == null || results.isEmpty()){
					findViewById(R.id.progress).setVisibility(View.GONE);
					text.setText(getString(R.string.no_prime) + path);
					return;
				}
				StringBuffer sb = new StringBuffer();
				for(Integer[] primes : results){
					sb.append(java.util.Arrays.toString(primes));
					sb.append(System.getProperty("line.separator") + System.getProperty("line.separator"));
				}
				text.setText(sb.toString());
				findViewById(R.id.progress).setVisibility(View.GONE);
			}
		});
	}
}
