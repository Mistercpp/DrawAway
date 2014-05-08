package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

import com.android.volley.toolbox.StringRequest;

/**
 * Created by Hor on 06/05/14.
 */
public class Triangle extends Figure {

    public void create(Canvas canvas, Paint paint) {

        Path tri = new Path();
        tri.moveTo(0 , this.getY());
        tri.lineTo(this.getX()/2 , 0);
        tri.lineTo(this.getX() , this.getY());
        tri.lineTo(0 , this.getY());
        tri.close();
        canvas.drawPath(tri, paint);

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
