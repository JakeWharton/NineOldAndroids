package com.nineoldandroids.view.animation;

import java.util.WeakHashMap;
import android.graphics.Camera;
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

    private static final WeakHashMap<View, AnimatorProxy> PROXIES =
            new WeakHashMap<View, AnimatorProxy>();

    /**
     * Create a proxy to allow for modifying post-3.0 view properties on all
     * pre-3.0 platforms. <strong>DO NOT</strong> wrap your views if you are
     * using {@code ObjectAnimator} as it will handle that itself.
     *
     * @param view View to wrap.
     * @return Proxy to post-3.0 properties.
     */
    public static AnimatorProxy wrap(View view) {
        AnimatorProxy proxy = PROXIES.get(view);
        if (proxy == null) {
            proxy = AnimatorProxy.wrap(view);
            PROXIES.put(view, proxy);
        }
        return proxy;
    }

    private final View mView;
    private final ViewGroup mViewParent;
    private final Camera mCamera;
    private boolean mHasPivot = false;

    private float mAlpha = 1;
    private float mPivotX = 0;
    private float mPivotY = 0;
    private float mRotationX = 0;
    private float mRotationY = 0;
    private float mRotationZ = 0;
    private float mScaleX = 1;
    private float mScaleY = 1;
    private float mTranslationX = 0;
    private float mTranslationY = 0;

    private AnimatorProxy(View view) {
        setDuration(0); //perform transformation immediately
        setFillAfter(true); //persist transformation beyond duration
        view.setAnimation(this);
        mView = view;
        mViewParent = (ViewGroup)view.getParent();
        mCamera = new Camera();
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
        mHasPivot = true;
        if (mPivotX != pivotX) {
            mPivotX = pivotX;
            mViewParent.invalidate();
        }
    }
    public float getPivotY() {
        return mPivotY;
    }
    public void setPivotY(float pivotY) {
        mHasPivot = true;
        if (mPivotY != pivotY) {
            mPivotY = pivotY;
            mViewParent.invalidate();
        }
    }
    public float getRotation() {
        return mRotationZ;
    }
    public void setRotation(float rotation) {
        if (mRotationZ != rotation) {
            mRotationZ = rotation;
            mViewParent.invalidate();
        }
    }
    public float getRotationX() {
        return mRotationX;
    }
    public void setRotationX(float rotationX) {
        if (mRotationX != rotationX) {
            mRotationX = rotationX;
            mViewParent.invalidate();
        }
    }
    public float getRotationY() {
        return mRotationY;
    }
    public void setRotationY(float rotationY) {
        if (mRotationY != rotationY) {
            mRotationY = rotationY;
            mViewParent.invalidate();
        }
    }
    public float getScaleX() {
        return mScaleX;
    }
    public void setScaleX(float scaleX) {
        if (mScaleX != scaleX) {
            mScaleX = scaleX;
            mViewParent.invalidate();
        }
    }
    public float getScaleY() {
        return mScaleY;
    }
    public void setScaleY(float scaleY) {
        if (mScaleY != scaleY) {
            mScaleY = scaleY;
            mViewParent.invalidate();
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
            mViewParent.invalidate();
        }
    }
    public float getTranslationY() {
        return mTranslationY;
    }
    public void setTranslationY(float translationY) {
        if (mTranslationY != translationY) {
            mTranslationY = translationY;
            mViewParent.invalidate();
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

        final View view = mView;
        final float w = view.getWidth();
        final float h = view.getHeight();
        final Matrix m = t.getMatrix();

        final float rX = mRotationX;
        final float rY = mRotationY;
        final float rZ = mRotationZ;
        if ((rX != 0) || (rY != 0) || (rZ != 0)) {
            final Camera camera = mCamera;
            final boolean hasPivot = mHasPivot;
            final float pX = hasPivot ? mPivotX : w/2f;
            final float pY = hasPivot ? mPivotY : h/2f;
            camera.save();
            camera.rotateX(rX);
            camera.rotateY(rY);
            camera.rotateZ(-rZ);
            camera.getMatrix(m);
            camera.restore();
            m.preTranslate(-pX, -pY);
            m.postTranslate(pX, pY);
        }

        final float sX = mScaleX;
        final float sY = mScaleY;
        if ((sX != 0) || (sX != 0)) {
            final float deltaSX = ((sX * w) - w) / 2f;
            final float deltaSY = ((sY * h) - h) / 2f;
            m.postScale(sX, sY);
            m.postTranslate(-deltaSX, -deltaSY);
        }
        m.postTranslate(mTranslationX, mTranslationY);
    }
}
