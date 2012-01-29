package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;

class ViewPropertyAnimatorICS extends ViewPropertyAnimator {
    private final android.view.ViewPropertyAnimator mNative;

    ViewPropertyAnimatorICS(View view) {
        mNative = view.animate();
    }

    @Override
    public ViewPropertyAnimator setDuration(long duration) {
        mNative.setDuration(duration);
        return this;
    }

    @Override
    public long getDuration() {
        return mNative.getDuration();
    }

    @Override
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        mNative.setStartDelay(startDelay);
        return this;
    }

    @Override
    public long getStartDelay() {
        return mNative.getStartDelay();
    }

    @Override
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        mNative.setInterpolator(interpolator);
        return this;
    }

    @Override
    public ViewPropertyAnimator setListener(final AnimatorListener listener) {
        if (listener == null) {
            mNative.setListener(null);
        } else {
            mNative.setListener(new android.animation.Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(android.animation.Animator animation) {
                    listener.onAnimationStart(null);
                }

                @Override
                public void onAnimationRepeat(android.animation.Animator animation) {
                    listener.onAnimationRepeat(null);
                }

                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    listener.onAnimationEnd(null);
                }

                @Override
                public void onAnimationCancel(android.animation.Animator animation) {
                    listener.onAnimationCancel(null);
                }
            });
        }
        return this;
    }

    @Override
    public void start() {
        mNative.start();
    }

    @Override
    public void cancel() {
        mNative.cancel();
    }

    @Override
    public ViewPropertyAnimator x(float value) {
        mNative.x(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator xBy(float value) {
        mNative.xBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator y(float value) {
        mNative.y(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator yBy(float value) {
        mNative.yBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator rotation(float value) {
        mNative.rotation(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationBy(float value) {
        mNative.rotationBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationX(float value) {
        mNative.rotationX(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationXBy(float value) {
        mNative.rotationXBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationY(float value) {
        mNative.rotationY(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationYBy(float value) {
        mNative.rotationYBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator translationX(float value) {
        mNative.translationX(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator translationXBy(float value) {
        mNative.translationXBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator translationY(float value) {
        mNative.translationY(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator translationYBy(float value) {
        mNative.translationYBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleX(float value) {
        mNative.scaleX(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleXBy(float value) {
        mNative.scaleXBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleY(float value) {
        mNative.scaleY(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleYBy(float value) {
        mNative.scaleYBy(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator alpha(float value) {
        mNative.alpha(value);
        return this;
    }

    @Override
    public ViewPropertyAnimator alphaBy(float value) {
        mNative.alphaBy(value);
        return this;
    }
}
