package com.nineoldandroids.view.animation;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class AnimatorProxy extends Animation {
    public static final boolean NEEDS_PROXY = Integer.valueOf(Build.VERSION.SDK).intValue() < Build.VERSION_CODES.HONEYCOMB;
    private static final int PIVOT_EXPLICITLY_SET = 1 << 0;

    public static AnimatorProxy wrap(View view) {
        return new AnimatorProxy(view);
    }

    private final View mView;
    private int mFlags = 0;

    private float mAlpha = 1;
    private float mPivotX = 0;
    private float mPivotY = 0;
    private float mRotation = 0;
    private float mScaleX = 1;
    private float mScaleY = 1;
    private float mTranslationX = 0;
    private float mTranslationY = 0;

    private AnimatorProxy(View view) {
        super();
        setDuration(0); //perform transformation immediately
        setFillAfter(true); //persist transformation beyond duration
        view.setAnimation(this);
        mView = view;
    }

    public float getAlpha() {
        return mAlpha;
    }
    public void setAlpha(float alpha) {
        mAlpha = alpha;
        mView.invalidate();
    }
    public void setBackgroundColor(int color) {
        mView.setBackgroundColor(color);
    }
    public int getBottom() {
        return mView.getBottom();
    }
    public void setBottom(int bottom) {
        mView.setBottom(bottom);
    }
    public int getLeft() {
        return mView.getLeft();
    }
    public void setLeft(int left) {
        mView.setLeft(left);
    }
    public float getPivotX() {
        return mPivotX;
    }
    public void setPivotX(float pivotX) {
        mFlags |= PIVOT_EXPLICITLY_SET;
        if (mPivotX != pivotX) {
            mPivotX = pivotX;
            mView.invalidate();
        }
    }
    public float getPivotY() {
        return mPivotY;
    }
    public void setPivotY(float pivotY) {
        mFlags |= PIVOT_EXPLICITLY_SET;
        if (mPivotY != pivotY) {
            mPivotY = pivotY;
            mView.invalidate();
        }
    }
    public float getRight() {
        return mView.getRight();
    }
    public void setRight(int right) {
        mView.setRight(right);
    }
    public float getRotation() {
        return mRotation;
    }
    public void setRotation(float rotation) {
        if (mRotation != rotation) {
            mRotation = rotation;
            mView.invalidate();
        }
    }
    public float getScaleX() {
        return mScaleX;
    }
    public void setScaleX(float scaleX) {
        if (mScaleX != scaleX) {
            mScaleX = scaleX;
            mView.invalidate();
        }
    }
    public float getScaleY() {
        return mScaleY;
    }
    public void setScaleY(float scaleY) {
        if (mScaleY != scaleY) {
            mScaleY = scaleY;
            mView.invalidate();
        }
    }
    public int getScrollX() {
        return mView.getScrollX();
    }
    public void setScrollX(int value) {
        mView.setScrollX(value);
    }
    public int getScrollY() {
        return mView.getScrollY();
    }
    public void setScrollY(int value) {
        mView.setScrollY(value);
    }
    public int getTop() {
        return mView.getTop();
    }
    public void setTop(int top) {
        mView.setTop(top);
    }
    public float getTranslationX() {
        return mTranslationX;
    }
    public void setTranslationX(float translationX) {
        if (mTranslationX != translationX) {
            mTranslationX = translationX;
            mView.invalidate();
        }
    }
    public float getTranslationY() {
        return mTranslationY;
    }
    public void setTranslationY(float translationY) {
        if (mTranslationY != translationY) {
            mTranslationY = translationY;
            mView.invalidate();
        }
    }
    public float getX() {
        return mView.getLeft() + mTranslationX;
    }
    public void setX(float x) {
        setTranslationX(x - mView.getLeft());
    }
    public float getY() {
        return mView.getTop() + mTranslationY;
    }
    public void setY(float y) {
        setTranslationY(y - mView.getTop());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        t.setAlpha(mAlpha);

        final boolean hasPivot = (mFlags & PIVOT_EXPLICITLY_SET) != 0;
        final float pivotX = hasPivot ? mPivotX : (mView.getWidth() / 2f);
        final float pivotY = hasPivot ? mPivotY : (mView.getHeight() / 2f);

        final Matrix m = t.getMatrix();
        m.postScale(mScaleX, mScaleY);
        m.postTranslate(mTranslationX, mTranslationY);
        m.postRotate(mRotation, pivotX, pivotY);

        //Invalidate the entire parent for now
        ((ViewGroup)mView.getParent()).invalidate();
    }
}
