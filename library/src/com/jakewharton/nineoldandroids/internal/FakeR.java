package com.jakewharton.nineoldandroids.internal;

/**
 * Mirrors frameworks/base/core/res/res/values/public.xml values which should
 * be stable across platforms since any changes would break functionality.
 */
public final class FakeR {
    public static final class attr {
        public static final int duration = 0x01010198;
        public static final int interpolator = 0x01010141;
        public static final int ordering = 0x010102e2;
        public static final int propertyName = 0x010102e1;
        public static final int repeatCount = 0x010101bf;
        public static final int repeatMode = 0x010101c0;
        public static final int startOffset = 0x010101be;
        public static final int valueFrom = 0x010102de;
        public static final int valueTo = 0x010102df;
        public static final int valueType = 0x010102e0;
    }

    public static final class styleable {
        public static final int[] AnimatorSet = new int[] {
            FakeR.attr.ordering,
        };
        public static final int AnimatorSet_ordering = 0;

        public static final int[] PropertyAnimator = new int[] {
            FakeR.attr.propertyName,
        };
        public static final int PropertyAnimator_propertyName = 0;

        public static final int[] Animator = new int[] {
            FakeR.attr.duration,
            FakeR.attr.startOffset,
            FakeR.attr.valueType,
            FakeR.attr.valueFrom,
            FakeR.attr.valueTo,
            FakeR.attr.repeatCount,
            FakeR.attr.repeatMode,
            FakeR.attr.interpolator,
        };
        public static final int Animator_duration = 0;
        public static final int Animator_startOffset = 1;
        public static final int Animator_valueType = 2;
        public static final int Animator_valueFrom = 3;
        public static final int Animator_valueTo = 4;
        public static final int Animator_repeatCount = 5;
        public static final int Animator_repeatMode = 6;
        public static final int Animator_interpolator = 7;
    }
}
