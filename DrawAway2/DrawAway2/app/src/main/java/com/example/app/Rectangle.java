package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Hor on 30/04/14.
 */
public class Rectangle extends Figure {
    @Override
    public void create(Canvas canvas, Paint myPaint) {

        myPaint.setColor(Color.RED);
        myPaint.setStrokeWidth(3);
        myPaint.setStyle(Paint.Style.STROKE);
        Log.i(this.getClass().getName(), "onDraw...");

        canvas.drawRect(this.getX(),this.getY(),this.getX() + this.getLargeur(),this.getY() + this.getHauteur(),myPaint);
        Log.i(this.getClass().getName(),"r : "+ this.getLargeur() + " x "+this.getHauteur());

    }
    public Rectangle()
    {
        this(100,50,50,50);
    }

    public Rectangle(int largeur, int hauteur, int x, int y) {
        this._largeur = largeur;
        this._hauteur = hauteur;
        this._x = x;
        this._y = y;
    }

    public int getLargeur() {
        return _largeur;
    }

    public int getHauteur() {
        return _hauteur;
    }

    public void setLargeur(int largeur) {
        this._largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this._hauteur = hauteur;
    }

    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }

    int _largeur, _hauteur;
    int _x, _y;

}
