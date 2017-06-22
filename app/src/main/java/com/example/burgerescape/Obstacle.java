package com.example.burgerescape;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class Obstacle {

	//Attributs
	private float mHauteurObstacle;
	private float mLargeurObstacle;
	private String mType;
	private float mPosX, mPosY;
	private Bitmap mImage;
	public RectF mRectangle;

	//GETTERS AND SETTERS
	public float getmPosY() {
		return mPosY;
	}

	public void setmPosY(float mPosY) {
		this.mPosY = mPosY;
	}
	
	public Bitmap getmImage() {
		return mImage;
	}

	public void setmImage(Bitmap mImage)
	{
		this.mImage = mImage;
	}
	

	public RectF getRectangle()
	{
		if(mType == "gauche")
		{
			return new RectF(mPosX,mPosY,mPosX + mLargeurObstacle, mPosY + mHauteurObstacle);
		}
		else
		{
			return new RectF(Game.largeur - mLargeurObstacle,mPosY,Game.largeur,mPosY + mHauteurObstacle);
		}
	}

	
	//Methodes
	public Obstacle(float x,float y,String type,double coeffDiviseurHauteur, double coeffDiviseurLargeur)
	{
		this.mPosX = x;
		this.mPosY = y;
		this.mType = type;	
		this.mHauteurObstacle = (float) (Game.hauteur / coeffDiviseurHauteur);
		this.mLargeurObstacle = (float) (Game.largeur / coeffDiviseurLargeur);
		
		this.mRectangle = getRectangle();
			
	}
	
	public void updatePosition(double y)
	{
		this.mPosY += y;
		
	}
}
