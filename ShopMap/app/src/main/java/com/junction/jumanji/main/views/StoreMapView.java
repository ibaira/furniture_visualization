package com.junction.jumanji.main.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.junction.jumanji.main.R;

/**
 * Created by Jorge on 11/26/2016.
 */
public class StoreMapView extends ImageView {

    public StoreMapView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public StoreMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StoreMapView(Context context) {
        super(context);
    }

    private ScaleGestureDetector mScaleDetector;
    private float mScaleFactor = 1.f;


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        // Let the ScaleGestureDetector inspect all events.
        mScaleDetector.onTouchEvent(ev);
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        canvas.scale(mScaleFactor, mScaleFactor);
        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
//        drawingImageView = (ImageView) this.findViewById(R.id.DrawingImageView);

        Bitmap bitmap = Bitmap.createBitmap((int) ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay().getWidth(), (int) ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        this.setImageBitmap(bitmap);

        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.store), 0, 0, null);
//        canvas.drawBitmap(bitmap,0,0,null);
        // Path

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(10);
        Path p = new Path();
        int h = canvas.getHeight();
        int w = canvas.getWidth();

        p.moveTo((float) (0.9 * w), (float) (0.8 * h));
        p.lineTo((float) (0.9 * w), (float) (0.45 * h));
        p.lineTo((float) (0.6 * w), (float) (0.45 * h));
        p.lineTo((float) (0.6 * w), (float) (0.05 * h));
        p.lineTo((float) (0.05 * w), (float) (0.05 * h));
        p.lineTo((float) (0.05 * w), (float) (0.8 * h));
        canvas.drawPath(p, paint);
        canvas.restore();
    }

}
