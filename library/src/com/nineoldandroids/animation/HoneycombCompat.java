package com.nineoldandroids.animation;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import android.view.View;
import com.nineoldandroids.util.FloatProperty;
import com.nineoldandroids.util.IntProperty;
import com.nineoldandroids.util.Property;
import com.nineoldandroids.view.animation.AnimatorProxy;

final class HoneycombCompat {
    private static final Map<Integer, WeakReference<AnimatorProxy>> PROXY_MAP = new HashMap<Integer, WeakReference<AnimatorProxy>>();

    private static AnimatorProxy getProxy(View view) {
        final Integer hashCode = view.hashCode(); //autobox once
        AnimatorProxy proxy = null;
        WeakReference<AnimatorProxy> proxyRef = PROXY_MAP.get(hashCode);
        if (proxyRef != null) {
            proxy = proxyRef.get();
        }
        if (proxy == null) {
            View targetView = (View)view;
            proxy = AnimatorProxy.wrap(targetView);
            PROXY_MAP.put(hashCode, new WeakReference<AnimatorProxy>(proxy));
        }
        return proxy;
    }

    static Property<View, Float> ALPHA = new FloatProperty<View>("alpha") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setAlpha(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getAlpha();
        }
    };
    static Property<View, Float> PIVOT_X = new FloatProperty<View>("pivotX") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setPivotX(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getPivotX();
        }
    };
    static Property<View, Float> PIVOT_Y = new FloatProperty<View>("pivotY") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setPivotY(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getPivotY();
        }
    };
    static Property<View, Float> TRANSLATION_X = new FloatProperty<View>("translationX") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setTranslationX(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getTranslationX();
        }
    };
    static Property<View, Float> TRANSLATION_Y = new FloatProperty<View>("translationY") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setTranslationY(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getTranslationY();
        }
    };
    static Property<View, Float> ROTATION = new FloatProperty<View>("rotation") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setRotation(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getRotation();
        }
    };
    static Property<View, Float> ROTATION_X = new FloatProperty<View>("rotationX") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setRotationX(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getRotationX();
        }
    };
    static Property<View, Float> ROTATION_Y = new FloatProperty<View>("rotationY") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setRotationY(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getRotationY();
        }
    };
    static Property<View, Float> SCALE_X = new FloatProperty<View>("scaleX") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setScaleX(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getScaleX();
        }
    };
    static Property<View, Float> SCALE_Y = new FloatProperty<View>("scaleY") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setScaleY(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getScaleY();
        }
    };
    static Property<View, Integer> SCROLL_X = new IntProperty<View>("scrollX") {
        @Override
        public void setValue(View object, int value) {
            getProxy(object).setScrollX(value);
        }

        @Override
        public Integer get(View object) {
            return getProxy(object).getScrollX();
        }
    };
    static Property<View, Integer> SCROLL_Y = new IntProperty<View>("scrollY") {
        @Override
        public void setValue(View object, int value) {
            getProxy(object).setScrollY(value);
        }

        @Override
        public Integer get(View object) {
            return getProxy(object).getScrollY();
        }
    };
    static Property<View, Float> X = new FloatProperty<View>("x") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setX(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getX();
        }
    };
    static Property<View, Float> Y = new FloatProperty<View>("y") {
        @Override
        public void setValue(View object, float value) {
            getProxy(object).setY(value);
        }

        @Override
        public Float get(View object) {
            return getProxy(object).getY();
        }
    };


    //No instances
    private HoneycombCompat() {}
}
