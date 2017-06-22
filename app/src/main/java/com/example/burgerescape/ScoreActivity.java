package com.example.burgerescape;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;



public class ScoreActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.score);
	}
	@Override
	public void onStop(){
		super.onStop();
		finish();
	}
	
	public void onBackClick(View v){
		finish();
	}
}
