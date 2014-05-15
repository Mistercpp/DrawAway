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
    Paint _myPaint;

    public Paint get_myPaint() {
        return _myPaint;
    }

    public void set_myPaint(Paint _myPaint) {
        this._myPaint = _myPaint;
    }

    public Circle(int x, int y, int radius,Paint myPaint) {
        this._radius = radius;
        this._x = x;
        this._y = y;
        this._myPaint = myPaint;
    }


    public void create(Canvas canvas) {
        canvas.drawCircle(this.getX(), this.getY(), this.getRadius(), this.get_myPaint());
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
