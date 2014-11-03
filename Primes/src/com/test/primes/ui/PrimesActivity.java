package com.test.primes.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.test.primes.R;
import com.test.primes.utils.Primes;

public class PrimesActivity extends ActionBarActivity {

	private static final int PICKFILE_RESULT_CODE = 35264;
	PrimeGen pgen;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_primes);
		
		((Button)findViewById(R.id.fileButton)).setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0) {
				if(pgen != null)
					pgen.cancel(true);
				Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("file/*");
				startActivityForResult(intent, PICKFILE_RESULT_CODE);
			}
		});
	}

	@Override
	public void onStart(){
		super.onStart();

		findViewById(R.id.progress).setVisibility(View.VISIBLE);
		((TextView)findViewById(R.id.text)).setText("");
		pgen = new PrimeGen();
		pgen.execute(312312);
	}
	
	@Override
	public void onStop(){
		if(pgen != null)
			pgen.cancel(true);
		
		super.onStop();
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode == PICKFILE_RESULT_CODE && resultCode == Activity.RESULT_OK){
			
		}
	}
	
	
	private 
}
