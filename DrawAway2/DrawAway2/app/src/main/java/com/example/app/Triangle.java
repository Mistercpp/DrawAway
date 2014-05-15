package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

/**
 * Created by Hor on 06/05/14.
 */
public class Triangle extends Figure {

    public void create(Canvas canvas){
        //pour le cas du triangle les point sont construit par rapport au centre
        Path tri = new Path();
        tri.moveTo(this.getX()-(this._base/2) ,this.getY()+(this._hauteur/2));
        tri.lineTo(this.getX() , this.getY()-(this._hauteur/2));
        tri.lineTo(this.getX()+(this._base/2) ,this.getY()+(this._hauteur/2));
        tri.lineTo(this.getX()-(this._base/2) ,this.getY()+(this._hauteur/2));
        tri.close();
        canvas.drawPath(tri, this.get_myPaint());

    }

    int _x;
    int _y;
    int _base;
    int _hauteur;
    Paint _myPaint;


    public Paint get_myPaint() {
        return _myPaint;
    }

    public void set_myPaint(Paint _myPaint) {
        this._myPaint = _myPaint;
    }

    public Triangle(int x, int y,int base,int hauteur,Paint myPaint){
        _x = x;
        _y = y;
        _base = base;
        _hauteur = hauteur;
        this._myPaint = myPaint;
    }

}
