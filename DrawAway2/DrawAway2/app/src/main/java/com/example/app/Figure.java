package com.example.app;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Hor on 30/04/14.
 */
public abstract class Figure {
    private int X;
    private int Y;

    public int getX() {
        return X;
    }

    public void setX(int X) {
        this.X = X;
    }

    public int getY() {
        return this.Y;
    }

    public void setY(int Y) {
        this.Y = Y;
    }



    protected Figure() {
        X = 0;
        Y = 0;
    }

    public abstract void create(Canvas canvas);
}
