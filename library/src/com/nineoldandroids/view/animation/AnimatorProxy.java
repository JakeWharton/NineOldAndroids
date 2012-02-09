package com.nineoldandroids.view.animation;

import java.util.WeakHashMap;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
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
            proxy = new AnimatorProxy(view);
            PROXIES.put(view, proxy);
        }
        return proxy;
    }

    private final View mView;
    private final ViewGroup mViewParent;
    private final Camera mCamera;
	private boolean mHasPivot;

    private float mAlpha = 1;
	private boolean mIdentity;
    private float mPivotX;
    private float mPivotY;
    private float mRotationX;
    private float mRotationY;
    private float mRotationZ;
    private float mScaleX = 1;
    private float mScaleY = 1;
    private float mTranslationX;
    private float mTranslationY;

	private final RectF mBefore = new RectF();
	private final RectF mAfter = new RectF();
	private final Matrix mTempMatrix = new Matrix();

    private AnimatorProxy(View view) {
        setDuration(0); //perform transformation immediately
        setFillAfter(true); //persist transformation beyond duration
        view.setAnimation(this);
        mView = view;
        mViewParent = (ViewGroup)view.getParent();
        mCamera = new Camera();
    }
	private void computeRect(final RectF r) {
		// compute current rectangle according to matrix transformation
		final View view = mView;
		final float w = view.getWidth();
		final float h = view.getHeight();

		// use a rectangle at 0,0 to make sure we don't run into issues with scaling
		r.set(0,0,w,h);

		final Matrix m = mTempMatrix;
		m.reset();
		transformMatrix(m);
		mTempMatrix.mapRect(r);

		r.offset(view.getLeft(), view.getTop());

		// Straighten coords if rotations flipped them
		if (r.right < r.left)
		{
			final float f = r.right;
			r.right = r.left;
			r.left = f;
		}
		if (r.bottom < r.top)
		{
			final float f = r.top;
			r.top = r.bottom;
			r.bottom = f;
		}
	}
	private void invalidate(RectF r) {
		mViewParent.invalidate((int) Math.floor(r.left),
							   (int) Math.floor(r.top),
							   (int) Math.ceil(r.right),
							   (int) Math.ceil(r.bottom));
	}
	private void prepareForUpdate() {
		computeRect(mBefore);
	}
	private void invalidateAfterUpdate() {
		computeRect(mAfter);
		mAfter.union(mBefore);
		invalidate(mAfter);
	}
    public float getAlpha() {
        return mAlpha;
    }
    public void setAlpha(float alpha) {
		if (mAlpha != alpha) {
			mAlpha = alpha;
			mView.invalidate();
		}
    }
    public float getPivotX() {
        return mPivotX;
    }
    public void setPivotX(float pivotX) {
        if (!mHasPivot || mPivotX != pivotX) {
			prepareForUpdate();
			mHasPivot = true;
            mPivotX = pivotX;
            invalidateAfterUpdate();
        }
    }
    public float getPivotY() {
        return mPivotY;
    }
    public void setPivotY(float pivotY) {
        if (!mHasPivot || mPivotY != pivotY) {
			prepareForUpdate();
			mHasPivot = true;
            mPivotY = pivotY;
            invalidateAfterUpdate();
        }
    }
    public float getRotation() {
        return mRotationZ;
    }
    public void setRotation(float rotation) {
        if (mRotationZ != rotation) {
			prepareForUpdate();
            mRotationZ = rotation;
            invalidateAfterUpdate();
        }
    }
    public float getRotationX() {
        return mRotationX;
    }
    public void setRotationX(float rotationX) {
        if (mRotationX != rotationX) {
			prepareForUpdate();
            mRotationX = rotationX;
            invalidateAfterUpdate();
        }
    }
    public float getRotationY() {
        return mRotationY;
    }

	public void setRotationY(float rotationY) {
        if (mRotationY != rotationY) {
			prepareForUpdate();
            mRotationY = rotationY;
            invalidateAfterUpdate();
        }
    }
    public float getScaleX()
	{
		return mScaleX;
    }
    public void setScaleX(float scaleX) {
        if (mScaleX != scaleX) {
			prepareForUpdate();
            mScaleX = scaleX;
            invalidateAfterUpdate();
        }
    }
    public float getScaleY() {
        return mScaleY;
    }
    public void setScaleY(float scaleY) {
        if (mScaleY != scaleY) {
			prepareForUpdate();
            mScaleY = scaleY;
            invalidateAfterUpdate();
        }
    }
	public float getScale() {
		// this is a pseudo-property for the frequent case where
		// scaleX and scaleY are being updated synchronously
		return Math.max(mScaleX, mScaleY);
	}
	public void setScale(float scale) {
		// this is a pseudo-property for the frequent case where
		// scaleX and scaleY are being updated synchronously
		if (mScaleX != scale || mScaleY != scale) {
			prepareForUpdate();
			mScaleX = scale;
			mScaleY = scale;
			invalidateAfterUpdate();
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
			prepareForUpdate();
            mTranslationX = translationX;
            invalidateAfterUpdate();
        }
    }
    public float getTranslationY() {
        return mTranslationY;
    }
    public void setTranslationY(float translationY) {
        if (mTranslationY != translationY) {
			prepareForUpdate();
            mTranslationY = translationY;
            invalidateAfterUpdate();
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
		transformMatrix(t.getMatrix());
    }

	private void transformMatrix(Matrix m) {
		final View view = mView;
		final float w = view.getWidth();
		final float h = view.getHeight();

		final float rX = mRotationX;
		final float rY = mRotationY;
		final float rZ = mRotationZ;
		if ((rX != 0) || (rY != 0) || (rZ != 0)) {
			final Camera camera = mCamera;
			final boolean hasPivot = mHasPivot;
			final float pX = hasPivot ? mPivotX : w / 2f;
			final float pY = hasPivot ? mPivotY : h / 2f;
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
		if ((sX != 1.0f) || (sY != 1.0f)) {
			final float deltaSX = ((sX * w) - w) / 2f;
			final float deltaSY = ((sY * h) - h) / 2f;
			m.postScale(sX, sY);
			m.postTranslate(-deltaSX, -deltaSY);
		}
		m.postTranslate(mTranslationX, mTranslationY);
	}
}
