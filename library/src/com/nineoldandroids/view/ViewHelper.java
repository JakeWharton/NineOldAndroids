package com.nineoldandroids.view;

import android.view.View;

import static com.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY;
import static com.nineoldandroids.view.animation.AnimatorProxy.wrap;

public final class ViewHelper {
    private ViewHelper() {}

    public static void setPivotX(View view, float pivotX) {
        if (NEEDS_PROXY) {
            wrap(view).setPivotX(pivotX);
        } else {
            SetPivotX.invoke(view, pivotX);
        }
    }

    public static void setPivotY(View view, float pivotY) {
        if (NEEDS_PROXY) {
            wrap(view).setPivotY(pivotY);
        } else {
            SetPivotY.invoke(view, pivotY);
        }
    }

    private static final class SetPivotX {
        static void invoke(View view, float pivotX) {
            view.setPivotX(pivotX);
        }
    }

    private static final class SetPivotY {
        static void invoke(View view, float pivotY) {
            view.setPivotY(pivotY);
        }
    }
}
