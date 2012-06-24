package com.nineoldandroids.view;

import android.view.View;

import static com.nineoldandroids.view.animation.AnimatorProxy.NEEDS_PROXY;
import static com.nineoldandroids.view.animation.AnimatorProxy.wrap;

public final class ViewHelper {
    private ViewHelper() {}

    public static float getAlpha(View view) {
        return NEEDS_PROXY ? wrap(view).getAlpha() : GetAlpha.invoke(view);
    }

    private static final class GetAlpha {
        static float invoke(View view) {
            return view.getAlpha();
        }
    }

    public static void setAlpha(View view, float alpha) {
        if (NEEDS_PROXY) {
            wrap(view).setAlpha(alpha);
        } else {
            SetAlpha.invoke(view, alpha);
        }
    }

    private static final class SetAlpha {
        static void invoke(View view, float alpha) {
            view.setAlpha(alpha);
        }
    }

    public static float getPivotX(View view) {
        return NEEDS_PROXY ? wrap(view).getPivotX() : GetPivotX.invoke(view);
    }

    private static final class GetPivotX {
        static float invoke(View view) {
            return view.getPivotX();
        }
    }

    public static void setPivotX(View view, float pivotX) {
        if (NEEDS_PROXY) {
            wrap(view).setPivotX(pivotX);
        } else {
            SetPivotX.invoke(view, pivotX);
        }
    }

    private static final class SetPivotX {
        static void invoke(View view, float pivotX) {
            view.setPivotX(pivotX);
        }
    }

    public static float getPivotY(View view) {
        return NEEDS_PROXY ? wrap(view).getPivotY() : GetPivotY.invoke(view);
    }

    private static final class GetPivotY {
        static float invoke(View view) {
            return view.getPivotY();
        }
    }

    public static void setPivotY(View view, float pivotY) {
        if (NEEDS_PROXY) {
            wrap(view).setPivotY(pivotY);
        } else {
            SetPivotY.invoke(view, pivotY);
        }
    }

    private static final class SetPivotY {
        static void invoke(View view, float pivotY) {
            view.setPivotY(pivotY);
        }
    }

    public static float getRotation(View view) {
        return NEEDS_PROXY ? wrap(view).getRotation() : GetRotation.invoke(view);
    }

    private static final class GetRotation {
        static float invoke(View view) {
            return view.getRotation();
        }
    }

    public static void setRotation(View view, float rotation) {
        if (NEEDS_PROXY) {
            wrap(view).setRotation(rotation);
        } else {
            SetRotation.invoke(view, rotation);
        }
    }

    private static final class SetRotation {
        static void invoke(View view, float rotation) {
            view.setRotation(rotation);
        }
    }

    public static void setRotationX(View view, float rotationX) {
        if (NEEDS_PROXY) {
            wrap(view).setRotationX(rotationX);
        } else {
            SetRotationX.invoke(view, rotationX);
        }
    }

    private static final class SetRotationX {
        static void invoke(View view, float rotationX) {
            view.setRotationX(rotationX);
        }
    }

    public static void setRotationY(View view, float rotationY) {
        if (NEEDS_PROXY) {
            wrap(view).setRotationY(rotationY);
        } else {
            SetRotationY.invoke(view, rotationY);
        }
    }

    private static final class SetRotationY {
        static void invoke(View view, float rotationY) {
            view.setRotationY(rotationY);
        }
    }

    public static void setScaleX(View view, float scaleX) {
        if (NEEDS_PROXY) {
            wrap(view).setScaleX(scaleX);
        } else {
            SetScaleX.invoke(view, scaleX);
        }
    }

    private static final class SetScaleX {
        static void invoke(View view, float scaleX) {
            view.setScaleX(scaleX);
        }
    }

    public static void setScaleY(View view, float scaleY) {
        if (NEEDS_PROXY) {
            wrap(view).setScaleY(scaleY);
        } else {
            SetScaleY.invoke(view, scaleY);
        }
    }

    private static final class SetScaleY {
        static void invoke(View view, float scaleY) {
            view.setScaleY(scaleY);
        }
    }

    public static void setScrollX(View view, int scrollX) {
        if (NEEDS_PROXY) {
            wrap(view).setScrollX(scrollX);
        } else {
            SetScrollX.invoke(view, scrollX);
        }
    }

    private static final class SetScrollX {
        static void invoke(View view, int scrollX) {
            view.setScrollX(scrollX);
        }
    }

    public static void setScrollY(View view, int scrollY) {
        if (NEEDS_PROXY) {
            wrap(view).setScrollY(scrollY);
        } else {
            SetScrollY.invoke(view, scrollY);
        }
    }

    private static final class SetScrollY {
        static void invoke(View view, int scrollY) {
            view.setScrollY(scrollY);
        }
    }

    public static void setTranslationX(View view, float translationX) {
        if (NEEDS_PROXY) {
            wrap(view).setTranslationX(translationX);
        } else {
            SetTranslationX.invoke(view, translationX);
        }
    }

    private static final class SetTranslationX {
        static void invoke(View view, float translationX) {
            view.setTranslationX(translationX);
        }
    }

    public static void setTranslationY(View view, float translationY) {
        if (NEEDS_PROXY) {
            wrap(view).setTranslationY(translationY);
        } else {
            SetTranslationY.invoke(view, translationY);
        }
    }

    private static final class SetTranslationY {
        static void invoke(View view, float translationY) {
            view.setTranslationY(translationY);
        }
    }

    public static void setX(View view, float x) {
        if (NEEDS_PROXY) {
            wrap(view).setX(x);
        } else {
            SetX.invoke(view, x);
        }
    }

    private static final class SetX {
        static void invoke(View view, float x) {
            view.setX(x);
        }
    }

    public static void setY(View view, float y) {
        if (NEEDS_PROXY) {
            wrap(view).setY(y);
        } else {
            SetY.invoke(view, y);
        }
    }

    private static final class SetY {
        static void invoke(View view, float y) {
            view.setY(y);
        }
    }
}
