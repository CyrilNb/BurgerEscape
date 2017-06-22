package com.example.burgerescape;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;


public class MainActivity extends Activity implements SensorEventListener {

	
	private SensorManager mSensorManager;
	  private Sensor mAcceler;
	  float mSensorX, mSensorY;
	  public Game game;
	  private Timer mTimer;


	  @Override
	  public final void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    mAcceler = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

	    game = new Game(getApplicationContext());
		setContentView(game);

	  }


	  protected synchronized void fritesUpdatePosition() {
			for(Obstacle obs : game.listeObstacle)
			{
				if(RectF.intersects(game.burger.getmRectangle(),obs.getRectangle()))
				{

					finish();
					game.nope();
					Intent intentGameOver = new Intent(this, LooseActivity.class);
					startActivity(intentGameOver);
					
					//A faire : passer le score ( temps écoulé ) entre les 2 activity et le sauvegarder
				}
				
				//Fais remonter sur l'axe Y, les frites. Impression que le terrain avance pour le burger comme ça.
				obs.updatePosition(-2.5);
			}
	  }

	  @Override
	  public final void onSensorChanged(SensorEvent event) {
		  
		  if(mAcceler.getType()==Sensor.TYPE_ACCELEROMETER){
			 this.mSensorX = event.values[0];
			 this.mSensorY = event.values[1];
		  }		 
	  }

	  @Override
	  protected void onResume() {
	    super.onResume();
	    
	    mSensorManager.registerListener(this, mAcceler, SensorManager.SENSOR_DELAY_GAME);
	    
	    mTimer = new Timer();
	    mTimer.schedule(new TimerTask() 
	    {
	    	public void run() {
	    		fritesUpdatePosition();
	    		game.burger.updatePosition(mSensorX, mSensorY);
	    	}
	    }
	    , 100, 10);
	  }

	  

	@Override
	  protected void onPause() {
	    super.onPause();
	    mSensorManager.unregisterListener(this);
	    mTimer.cancel();
	  }

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		mSensorManager.unregisterListener(this);
		mTimer.cancel();
		finish();
		game.nope();
	}

	  
	
}
