
package com.example.chenduo.cdtemplate.demo.folderlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by chenduo on 16-12-14.
 */

public class FolderLayout extends View {

    public float getmFactor() {
        return mFactor;
    }

    public void setmFactor(float mFactor) {
        this.mFactor = mFactor;

        mFinalWidth = (int) (mWidth * mFactor);
        mPerWidth = mWidth / NUM_OF_FOLDER;
        mPerFinalWidth = mFinalWidth / NUM_OF_FOLDER;

        initMatrices();

        updatePaint();

        invalidate();
    }

    float mFactor = 0;
    int mWidth;
    int mHeight;
    int mFinalWidth;
    int mPerWidth;
    int mPerFinalWidth;
    private static final int NUM_OF_FOLDER = 6;

    public FolderLayout(Context context) {
        super(context);
    }

    public FolderLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;
        mHeight = h;

        this.setmFactor(0.8f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for (int i = 0; i < NUM_OF_FOLDER; i++) {
            canvas.save();

            canvas.concat(mMatrices[i]);
            canvas.clipRect(i * mPerWidth, 0, (i + 1) * mPerWidth, mHeight);
            canvas.drawColor(Color.RED);

            // 移动到当前块
            canvas.translate(i * mPerWidth, 0);

            if (i % 2 == 0) {
                canvas.drawRect(0, 0, mPerWidth, mHeight, mSolidPaint);
            } else {
                canvas.drawRect(0, 0, mPerWidth, mHeight, mShadowPaint);
            }

            canvas.restore();
        }
    }

    Matrix[] mMatrices = new Matrix[NUM_OF_FOLDER];

    void initMatrices() {
        int offset = (int) (Math.sqrt(mPerWidth * mPerWidth - mPerFinalWidth * mPerFinalWidth));

        for (int i = 0; i < NUM_OF_FOLDER; i++) {
            if (mMatrices[i] == null) {
                mMatrices[i] = new Matrix();
            }

            float[] src = {
                    i * mPerWidth, 0,
                    (i + 1) * mPerWidth, 0,
                    (i + 1) * mPerWidth, mHeight,
                    i * mPerWidth, mHeight
            };

            boolean isEven = i % 2 == 0;
            float[] dst = {
                    i * mPerFinalWidth, isEven ? 0 : offset,
                    (i + 1) * mPerFinalWidth, isEven ? offset : 0,
                    (i + 1) * mPerFinalWidth, mHeight - (isEven ? offset : 0),
                    i * mPerFinalWidth, mHeight - (isEven ? 0 : offset)
            };

            mMatrices[i].setPolyToPoly(src, 0, dst, 0, src.length >> 1);
        }
    }

    Paint mSolidPaint = new Paint();
    Paint mShadowPaint = new Paint();
    LinearGradient mShadow = new LinearGradient(0, 0, 0.5f, 0, Color.BLACK, Color.TRANSPARENT,
            Shader.TileMode.CLAMP);

    void updatePaint() {
        int alpha = (int) (255 * (1 - mFactor));
        mSolidPaint.setARGB(alpha, 0, 0, 0);

        mShadowPaint.setStyle(Paint.Style.FILL);
        mShadowPaint.setShader(mShadow);
        Matrix m = new Matrix();
        m.setScale(mPerWidth, 1);
        mShadow.setLocalMatrix(m);
        mShadowPaint.setAlpha(alpha);
    }

}
