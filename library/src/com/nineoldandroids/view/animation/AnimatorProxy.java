package com.nineoldandroids.view.animation;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * A proxy class to allow for modifying post-3.0 view properties on all pre-3.0
 * platforms. <strong>DO NOT</strong> wrap your views with this class if you
 * are using {@code ObjectAnimator} as it will handle that itself.
 */
public final class AnimatorProxy extends Animation {
    /** Whether or not the current running platform needs to be proxied. */
    public static final boolean NEEDS_PROXY = Integer.valueOf(Build.VERSION.SDK).intValue() < Build.VERSION_CODES.HONEYCOMB;
    private static final int PIVOT_EXPLICITLY_SET = 1 << 0;

    /**
     * Create a proxy to allow for modifying post-3.0 view properties on all
     * pre-3.0 platforms. <strong>DO NOT</strong> wrap your views if you are
     * using {@code ObjectAnimator} as it will handle that itself.
     *
     * @param view View to wrap.
     * @return Proxy to post-3.0 properties.
     */
    public static AnimatorProxy wrap(View view) {
        return new AnimatorProxy(view);
    }

    private final View mView;
    private int mFlags = 0;

    private float mAlpha = 1;
    private float mPivotX = 0;
    private float mPivotY = 0;
    private float mRotation = 0;
    private float mRotationX = 0;
    private float mRotationY = 0;
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
    public float getRotation() {
        return mRotation;
    }
    public void setRotation(float rotation) {
        if (mRotation != rotation) {
            mRotation = rotation;
            mView.invalidate();
        }
    }
    public float getRotationX() {
        return mRotationX;
    }
    public void setRotationX(float rotationX) {
        if (mRotationX != rotationX) {
            mRotationX = rotationX;
            mView.invalidate();
        }
    }
    public float getRotationY() {
        return mRotationY;
    }
    public void setRotationY(float rotationY) {
        if (mRotationY != rotationY) {
            mRotationY = rotationY;
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
        mView.scrollTo(value, mView.getScrollY());
    }
    public int getScrollY() {
        return mView.getScrollY();
    }
    public void setScrollY(int value) {
        mView.scrollTo(mView.getScrollY(), value);
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
        m.preScale(mScaleX, mScaleY);
        m.preTranslate(mTranslationX, mTranslationY);
        m.preRotate(mRotation, pivotX, pivotY);

        final float rotX = mRotationX;
        if (rotX != 0) {
            Matrix rot = new Matrix();
            final float cos = (float)Math.cos(rotX);
            final float sin = (float)Math.sin(rotX);
            rot.setValues(new float[] {
                1, 0,   0,
                0, cos, -sin,
                0, sin, cos
            });
            m.postConcat(rot);
        }
        final float rotY = mRotationY;
        if (rotY != 0) {
            Matrix rot = new Matrix();
            final float cos = (float)Math.cos(rotY);
            final float sin = (float)Math.sin(rotY);
            rot.setValues(new float[] {
                cos,  0, sin,
                0,    1, 0,
                -sin, 0, cos
            });
            m.postConcat(rot);
        }

        //Invalidate the entire parent for now
        ((ViewGroup)mView.getParent()).invalidate();
    }
}
