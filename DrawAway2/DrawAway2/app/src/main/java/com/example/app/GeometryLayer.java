package com.example.app;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Hor on 30/04/14.
 */
public class GeometryLayer extends View {
    ArrayList<Figure> Listfigure = new ArrayList<Figure>();
    public GeometryLayer(Context context) {
        super(context);
    }

    public GeometryLayer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GeometryLayer(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addFigure(Figure f)
    {
        Listfigure.add(f);
        invalidate();
    }

    public void cleanSlate()
    {
        Listfigure.clear();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint myPaint = new Paint();
        myPaint.setColor(Color.RED);
        myPaint.setStrokeWidth(3);
        myPaint.setStyle(Paint.Style.STROKE);
        String figure;

        //draw the list of Figure
        for(Figure f : Listfigure){
            f.create(canvas, myPaint);
            if(figure.equals("Triangle"))
            {
                Path tri = new Path();
                tri.moveTo(0,f.getX());
                tri.lineTo(f.getX()/2,0);
                tri.lineTo(f.getX(),f.getY());
                tri.lineTo(0,f.getY());
                tri.close();
                canvas.drawPath(tri, myPaint);
            }
        }
    }

}
