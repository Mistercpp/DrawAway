package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Hor on 06/05/14.
 */
public class Triangle extends Figure {

    public void create(Canvas canvas, Paint paint) {
        canvas.drawColor(Color.CYAN);

    }

    int _x;
    int _y;
    int base;
    int hauteur;


    public Triangle(int x, int y){
        _x = x;
        _y = y;
    }

    public int getBase(){return base;}

    public int getHauteur(){return hauteur;}
}
