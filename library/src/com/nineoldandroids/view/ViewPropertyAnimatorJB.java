package com.nineoldandroids.view;

import android.annotation.TargetApi;
import android.view.View;

import static android.os.Build.VERSION_CODES.JELLY_BEAN;

@TargetApi(JELLY_BEAN)
class ViewPropertyAnimatorJB extends ViewPropertyAnimatorICS {

    ViewPropertyAnimatorJB(View view) {
        super(view);
    }

    @Override
    public ViewPropertyAnimator withLayer() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.withLayer();
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator withStartAction(Runnable runnable) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.withStartAction(runnable);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator withEndAction(Runnable runnable) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.withEndAction(runnable);
        }
        return this;
    }
}
