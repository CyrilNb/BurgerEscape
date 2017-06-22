package com.example.burgerescape;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

@SuppressLint("DrawAllocation")
public class Game extends SurfaceView implements SurfaceHolder.Callback
{
	SurfaceHolder maSurfaceHolder;
	DrawingThread monThread;
	Paint monPaint;
	public static int largeur,hauteur;
	public Burger burger;
	public List<Obstacle> listeObstacle;
	public RectF rectangle;
	
	
	public Game(Context context) {
		super(context);
		largeur = context.getResources().getDisplayMetrics().widthPixels; //1080
		hauteur = context.getResources().getDisplayMetrics().heightPixels; //1920
		maSurfaceHolder = getHolder();
		maSurfaceHolder.addCallback(this);
		monThread = new DrawingThread();
		monPaint = new Paint();
		monPaint.setStyle(Paint.Style.FILL);

		burger = new Burger(450,hauteur/8,4);
		Bitmap imageBurger = BitmapFactory.decodeResource(getResources(), R.drawable.burger);
		imageBurger = Bitmap.createScaledBitmap(imageBurger,50,50,true);
		burger.setmImage(imageBurger);
		
		
		
		//En dur pour tester le bon fonctionnement de l'appli
		//A factorisé. Fabrique random ?
		//Reflechir persistance : lecture d'un fichier JSON ?
		
		listeObstacle = new ArrayList<Obstacle>();
		
		
		Obstacle friteDroite1 = new Obstacle(0,900,"droite",14,3);
		Obstacle friteDroite2 = new Obstacle(0,1400,"droite",14,2.1);
		Obstacle friteDroite3 = new Obstacle(0,1700,"droite",14,2.8);
		Obstacle friteDroite4 = new Obstacle(0,2100,"droite",14,2.6);
		Obstacle friteDroite5 = new Obstacle(0,2500,"droite",14,5);
		Obstacle friteDroite6 = new Obstacle(0,2900,"droite",14,6);
		Obstacle friteDroite7 = new Obstacle(0,3260,"droite",14,6);
		Obstacle friteDroite8 = new Obstacle(0,3500,"droite",14,2.5);
		Obstacle friteDroite9 = new Obstacle(0,3800,"droite",14,3.3);
		Obstacle friteDroite10 = new Obstacle(0,4100,"droite",14,3);
		Obstacle friteDroite11 = new Obstacle(0,4350,"droite",14,4);
		Obstacle friteDroite12 = new Obstacle(0,4600,"droite",14,3.4);
		Obstacle friteDroite13 = new Obstacle(0,4880,"droite",14,5);
		Obstacle friteDroite14 = new Obstacle(0,5290,"droite",14,2.8);
		Obstacle friteDroite15 = new Obstacle(0,5630,"droite",14,7);
		Obstacle friteDroite16 = new Obstacle(0,5990,"droite",14,4);
		Obstacle friteDroite17 = new Obstacle(0,6240,"droite",14,1.8);
		Obstacle friteDroite18 = new Obstacle(0,6500,"droite",14,3.4);
		Obstacle friteDroite19 = new Obstacle(0,6970,"droite",14,2.9);
		Obstacle friteDroite20 = new Obstacle(0,7170,"droite",14,4);

		listeObstacle.add(friteDroite1);
		listeObstacle.add(friteDroite2);
		listeObstacle.add(friteDroite3);
		listeObstacle.add(friteDroite4);
		listeObstacle.add(friteDroite5);
		listeObstacle.add(friteDroite6);
		listeObstacle.add(friteDroite7);
		listeObstacle.add(friteDroite8);
		listeObstacle.add(friteDroite9);
		listeObstacle.add(friteDroite10);
		listeObstacle.add(friteDroite11);
		listeObstacle.add(friteDroite12);
		listeObstacle.add(friteDroite13);
		listeObstacle.add(friteDroite14);
		listeObstacle.add(friteDroite15);
		listeObstacle.add(friteDroite16);
		listeObstacle.add(friteDroite17);
		listeObstacle.add(friteDroite18);
		listeObstacle.add(friteDroite19);
		listeObstacle.add(friteDroite20);
		
		Obstacle friteGauche1 = new Obstacle(0,1000,"gauche",14,3.8);
		Obstacle friteGauche2 = new Obstacle(0,1500,"gauche",14,4);
		Obstacle friteGauche3 = new Obstacle(0,1900,"gauche",14,2.5);
		Obstacle friteGauche4 = new Obstacle(0,2500,"gauche",14,2.8);
		Obstacle friteGauche5 = new Obstacle(0,2900,"gauche",14,4.3);
		Obstacle friteGauche6 = new Obstacle(0,3200,"gauche",14,5);
		Obstacle friteGauche7 = new Obstacle(0,3600,"gauche",14,2.9);
		Obstacle friteGauche8 = new Obstacle(0,3850,"gauche",14,5);
		Obstacle friteGauche9 = new Obstacle(0,4200,"gauche",14,3.8);
		Obstacle friteGauche10 = new Obstacle(0,4500,"gauche",14,2.7);
		Obstacle friteGauche11 = new Obstacle(0,4900,"gauche",14,6.3);
		Obstacle friteGauche12 = new Obstacle(0,5320,"gauche",14,5);
		Obstacle friteGauche13 = new Obstacle(0,5650,"gauche",14,2.3);
		Obstacle friteGauche14 = new Obstacle(0,6060,"gauche",14,3.2);
		Obstacle friteGauche15 = new Obstacle(0,6200,"gauche",14,3.9);
		Obstacle friteGauche16 = new Obstacle(0,6600,"gauche",14,3);
		Obstacle friteGauche17 = new Obstacle(0,6910,"gauche",14,4.3);
		Obstacle friteGauche18 = new Obstacle(0,7290,"gauche",14,4.9);
		Obstacle friteGauche19 = new Obstacle(0,7460,"gauche",14,2.7);
		Obstacle friteGauche20 = new Obstacle(0,7850,"gauche",14,5.6);
		listeObstacle.add(friteGauche1);
		listeObstacle.add(friteGauche2);
		listeObstacle.add(friteGauche3);
		listeObstacle.add(friteGauche4);
		listeObstacle.add(friteGauche5);
		listeObstacle.add(friteGauche6);
		listeObstacle.add(friteGauche7);
		listeObstacle.add(friteGauche8);
		listeObstacle.add(friteGauche9);
		listeObstacle.add(friteGauche10);
		listeObstacle.add(friteGauche11);
		listeObstacle.add(friteGauche12);
		listeObstacle.add(friteGauche13);
		listeObstacle.add(friteGauche14);
		listeObstacle.add(friteGauche15);
		listeObstacle.add(friteGauche16);
		listeObstacle.add(friteGauche17);
		listeObstacle.add(friteGauche18);
		listeObstacle.add(friteGauche19);
		listeObstacle.add(friteGauche20);


		
		
	}
	
	/*
	private void generateObstacles(int nbFrites,String typeFrites){
		for (int j = 0; j < nbFrites; j++)
		{
			Obstacle friteDroite = new Obstacle(0,900,typeFrites);
		}
	}*/
	
	
	@Override
	public void onDraw(Canvas canvas) {
		this.monPaint.setStyle(Paint.Style.FILL);
	    this.monPaint.setColor(Color.MAGENTA); 
		canvas.drawColor(Color.LTGRAY);
		
		//Draw the burger
		Rect rectBurger = new Rect(0,0,burger.getmImage().getWidth(),burger.getmImage().getHeight());
		canvas.drawBitmap(burger.getmImage(),rectBurger,burger.getmRectangle(),null);
		
		//Draw frites in listeObstacle
		monPaint.setColor(Color.YELLOW);
		for(Obstacle obs : listeObstacle)
		{
			canvas.drawRect(obs.getRectangle(), monPaint);
		}
		
	}

	public void nope(){
		this.destroyDrawingCache();
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		monThread.draw = true;
		monThread.start();	
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		monThread.draw = false;
	}

	private class DrawingThread extends Thread {
	    boolean draw = true;
	    
	    @SuppressLint("WrongCall")
		@Override
	    public void run() 
	    {
	        Canvas canvas;
	        while (draw ) 
	        {
	            canvas = null;
	            try 
	            {
	                canvas = maSurfaceHolder.lockCanvas();
	                synchronized (maSurfaceHolder) 
	                {
	                    onDraw(canvas);
	                }
	            } 
	            finally 
	            {
	                if (canvas != null)
	                    maSurfaceHolder.unlockCanvasAndPost(canvas);
	            }
	            
	            try 
	            {
	                Thread.sleep(10);
	            } 
	            
	            catch (InterruptedException e) {}
	        }
	    }
	}
}
