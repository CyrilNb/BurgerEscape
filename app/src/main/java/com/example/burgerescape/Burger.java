package com.example.burgerescape;

import android.graphics.Bitmap;
import android.graphics.RectF;

public class Burger{

	//Attributs
	
	private Bitmap mImage;
	private float mPosX;
	private float mPosY;
	private RectF mRectangle;
	private float mCoeffVitesse;
	
	
	
	public RectF getmRectangle() {
		return mRectangle;
	}


	public void setmRectangle(RectF mRectangle) {
		this.mRectangle = mRectangle;
	}


	public Bitmap getmImage() {
		return mImage;
	}


	public void setmImage(Bitmap mImage) {
		this.mImage = mImage;
	}


	public Burger(float posX,float posY,float coeffVit) {
		this.mPosX = posX;
		this.mPosY = posY;
		this.mCoeffVitesse = coeffVit;
		
		this.mRectangle = new RectF(mPosX,mPosY,Game.largeur/6,Game.hauteur/8);
	} 
	
	
	public void updatePosition(float x,float y)
	{
		mPosX -= x * (this.mCoeffVitesse);
		
		//Ajout d'un coefficient de vitesse.
		//Pour pouvoir plus tard ralentir ou accelerer le déplacement du burger avec des objets spéciaux qui seront à prendre sur le chemin.
		
		//Ici pas besoin d'update la position en Y, puisqu'on souhaite pour l'instant qu'il se deplace que sur les côtés.
		//A voir plus tard si on veut aussi que l'utilisateur gère sa vitesse de descente ou non. A réfléchir
		
		//mPosY += y;
		
		mRectangle = new RectF(mPosX, mPosY, mPosX + Game.largeur/6, mPosY + Game.hauteur/8);
	}

}