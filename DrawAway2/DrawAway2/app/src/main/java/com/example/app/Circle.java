package com.example.app;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Hor on 30/04/14.
 */
public class Circle extends Figure {

    int _radius;
    int _x, _y;

    public Circle(){
        this(100,40,0);
    }

    public Circle(int x, int y, int radius) {
        this._radius = radius;
        this._x = x;
        this._y = y;
    }
    @Override
    public void create(Canvas canvas, Paint paint) {
        Paint p = new Paint();
        // smooths
        p.setAntiAlias(true);
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(4.5f);
        // opacity
        //p.setAlpha(0x80); //
        canvas.drawCircle(this.getX(), this.getY(), this.getRadius(), p);
    }

    public int getRadius() {
        return _radius;
    }


    public int getX() {
        return _x;
    }

    public int getY() {
        return _y;
    }
}
