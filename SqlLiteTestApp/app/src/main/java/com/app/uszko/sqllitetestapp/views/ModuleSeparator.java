package com.app.uszko.sqllitetestapp.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

/**
 * Created by igbt6 on 09.01.2016.
 */
public class ModuleSeparator extends View {

    Paint mPaint;
    Random mRandom = new Random();


    public ModuleSeparator(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0, 0, canvas.getWidth(), 0, mPaint);

    }
    private void  setupPaint(){
        mPaint= new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

    }
}
