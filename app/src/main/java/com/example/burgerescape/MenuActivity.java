package com.example.burgerescape;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.menu);
	}
	
	public void onPlayClick(View v){
		Intent intent = new Intent(this, MainActivity.class);
	 	startActivity(intent);
	}
	
	public void onLeaveClick(View v){
		finish();
        System.exit(0);
	}
	
	public void onScoreClick(View v){
		Intent intent1 = new Intent(this, ScoreActivity.class);
	 	startActivity(intent1);
	}

}
