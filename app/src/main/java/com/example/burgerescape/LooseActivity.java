package com.example.burgerescape;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class LooseActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.loose);
	}
	
	public void onLeaveClick(View v){
		finish();
	}
	
	public void onReplayClick(View v){
		finish();
		Intent intent = new Intent(this, MainActivity.class);
	 	startActivity(intent);
	}
	
}