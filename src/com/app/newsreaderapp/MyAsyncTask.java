package com.app.newsreaderapp;

import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

class MyAsynTask extends AsyncTask<String, Integer, String>
{

	private static final String asyncTextView = null;
	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String result="";
		int myProgress=0;
		//int inputLength = params[0].length();
		//for(int i=1; i<=inputLength; i++)
		{
			//myProgress= i;
			//result= result + params[0].charAt(inputLength-i);
			try
			{
				
				loadFeed(ParserType.ANDROID_SAX);
			}
			catch(Exception e){}
			publishProgress(myProgress);
		}
		
		return result;
	}

	private void loadFeed(ParserType androidSax) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		//asyncTextView.setText(result);
		//super.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	private void executeAsync(){
		String input = "redrum...redrum";
		new MyAsynTask().execute(input);
		
	}
	private void backgroundExecution()
	{
		Thread thread = new Thread (null,doBackgroundThreadProcessing, "Background" );
		thread.start();
	}
	private Runnable doBackgroundThreadProcessing= new Runnable()
	{
		public void run()
		{
			backgroundThreadProcessing();
		}

		private void backgroundThreadProcessing() {
			// TODO Auto-generated method stub
			handler.post(doUpdateGUI);
			
		}
	private Handler handler = new Handler();
	private Runnable doUpdateGUI =new Runnable() {
		public void run()
		{
			updateGUI();
		}

		private void updateGUI() {
			// TODO Auto-generated method stub
			
		}
		
		
	};

	};

}
