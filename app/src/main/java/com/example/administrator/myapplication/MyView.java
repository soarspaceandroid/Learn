package com.example.administrator.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/5/26.
 */

public class MyView extends View {


    private Paint paint = new Paint();
    private Rect clientRect = new Rect(0,0,500,500);
    private LinearGradient shader;

    private int huanW = 0;


    public MyView(Context context) {
        super(context);
        initView();
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    public void initView(){
        int colors[] = new int[3];
        float positions[] = new float[3];
        // 第1个点
        colors[0] = 0xFF111111;
        positions[0] = 0;

        // 第2个点
        colors[1] = 0xFF999999;
        positions[1] = 0.5f;

        // 第3个点
        colors[2] = 0xFF00FF11;
        positions[2] = 1;

        shader = new LinearGradient(
                0, 0,
                0, 444,
                colors,
                positions,
                Shader.TileMode.MIRROR);

        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        changeValue();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        int center = getWidth()/2;
        int ringWidth = 10;   //圆环宽度

        paint.setStrokeCap(Paint.Cap.ROUND);

        //绘制圆环
        this.paint.setARGB(255, 138, 43, 226);
        this.paint.setStrokeWidth(ringWidth);
        canvas.drawCircle(center, center, huanW, this.paint);

        paint.setShader(shader);
        canvas.drawRect(clientRect , paint);
        invalidate();
    }


    public void changeValue(){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0 , 60);
        valueAnimator.setRepeatCount(0);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                huanW = (int)animation.getAnimatedValue();
            }
        });
        valueAnimator.start();
    }
}
