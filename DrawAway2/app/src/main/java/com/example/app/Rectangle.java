package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;

/**
 * Created by Hor on 30/04/14.
 */
public class Rectangle extends Figure {

    public void create(Canvas canvas) {
        canvas.drawRect(this.getX(), this.getY(), this.getX() + this.getLargeur(), this.getY() + this.getHauteur(), this.get_myPaint());
    }

    public Paint get_myPaint() {
        return _myPaint;
    }

    public void set_myPaint(Paint _myPaint) {
        this._myPaint = _myPaint;
    }

    public Rectangle(int largeur, int hauteur, int x, int y,Paint myPaint) {
        this._largeur = largeur;
        this._hauteur = hauteur;

        this._myPaint = myPaint;

        setX(x);
        setY(y);
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



    int _largeur, _hauteur;
    Paint _myPaint;

}
