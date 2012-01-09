package com.nineoldandroids.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridLayout;

import com.nineoldandroids.view.animation.AnimatorProxy;

public class NineGridLayout extends GridLayout {
    private AnimatorProxy mProxy;

    public NineGridLayout(Context context) {
        super(context);
        mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }
    public NineGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }
    public NineGridLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mProxy = AnimatorProxy.NEEDS_PROXY ? AnimatorProxy.wrap(this) : null;
    }

    public float getAlpha() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getAlpha() : super.getAlpha();
    }
    public void setAlpha(float alpha) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setAlpha(alpha);
        } else {
            super.setAlpha(alpha);
        }
    }
    public float getRotation() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getRotation() : super.getRotation();
    }
    public void setRotation(float rotation) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setRotation(rotation);
        } else {
            super.setRotation(rotation);
        }
    }
    public float getScaleX() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getScaleX() : super.getScaleX();
    }
    public void setScaleX(float scaleX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setScaleX(scaleX);
        } else {
            super.setScaleX(scaleX);
        }
    }
    public float getScaleY() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getScaleY() : super.getScaleY();
    }
    public void setScaleY(float scaleY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setScaleY(scaleY);
        } else {
            super.setScaleY(scaleY);
        }
    }
    public float getTranslationX() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getTranslationX() : super.getTranslationX();
    }
    public void setTranslationX(float translationX) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setTranslationX(translationX);
        } else {
            super.setTranslationX(translationX);
        }
    }
    public float getTranslationY() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getTranslationY() : super.getTranslationY();
    }
    public void setTranslationY(float translationY) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setTranslationY(translationY);
        } else {
            super.setTranslationY(translationY);
        }
    }
    public float getX() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getX() : super.getX();
    }
    public void setX(float x) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setX(x);
        } else {
            super.setX(x);
        }
    }
    public float getY() {
        return AnimatorProxy.NEEDS_PROXY ? mProxy.getY() : super.getY();
    }
    public void setY(float y) {
        if (AnimatorProxy.NEEDS_PROXY) {
            mProxy.setY(y);
        } else {
            super.setY(y);
        }
    }
}
