package com.nineoldandroids.view;

import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.lang.ref.WeakReference;
import java.util.HashMap;

import static android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH;

@TargetApi(ICE_CREAM_SANDWICH)
class ViewPropertyAnimatorICS extends ViewPropertyAnimator {
    /**
     * A value to be returned when the WeakReference holding the native implementation
     * returns <code>null</code>
     */
    private final static long RETURN_WHEN_NULL = -1L;

    /**
     * A WeakReference holding the View whose properties are being animated by this class.
     * This is set at construction time.
     */
    private final WeakReference<View> mView;

    /**
     * A WeakReference holding the native implementation of ViewPropertyAnimator
     */
    protected final WeakReference<android.view.ViewPropertyAnimator> mNative;

    /**
     * Listener for the lifecycle events of the underlying animator.
     */
    private Animator.AnimatorListener mListener = null;

    /**
     * This listener is the mechanism by which the underlying Animator causes changes to the
     * properties currently being animated, as well as the cleanup after an animation is
     * complete.
     */
    private AnimatorEventListener mAnimatorEventListener = new AnimatorEventListener();

    private Runnable mPendingSetupAction;
    private Runnable mPendingCleanupAction;
    private Runnable mPendingOnStartAction;
    private Runnable mPendingOnEndAction;

    private HashMap<android.animation.Animator, Runnable> mAnimatorSetupMap;
    private HashMap<android.animation.Animator, Runnable> mAnimatorCleanupMap;
    private HashMap<android.animation.Animator, Runnable> mAnimatorOnStartMap;
    private HashMap<android.animation.Animator, Runnable> mAnimatorOnEndMap;

    ViewPropertyAnimatorICS(View view) {
        mView = new WeakReference<View>(view);
        android.view.ViewPropertyAnimator vpi = view.animate();
        vpi.setListener(mAnimatorEventListener);
        mNative = new WeakReference<android.view.ViewPropertyAnimator>(vpi);
    }

    @Override
    public ViewPropertyAnimator setDuration(long duration) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.setDuration(duration);
        }
        return this;
    }

    @Override
    public long getDuration() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            return n.getDuration();
        }
        return RETURN_WHEN_NULL;
    }

    @Override
    public ViewPropertyAnimator setStartDelay(long startDelay) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.setStartDelay(startDelay);
        }
        return this;
    }

    @Override
    public long getStartDelay() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            return n.getStartDelay();
        }
        return RETURN_WHEN_NULL;
    }

    @Override
    public ViewPropertyAnimator setInterpolator(Interpolator interpolator) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.setInterpolator(interpolator);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator setListener(Animator.AnimatorListener listener) {
        mListener = listener;
        return this;
    }

    @Override
    public void start() {
        startAnimation();
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.start();
        }
    }

    @Override
    public void cancel() {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.cancel();
        }
    }

    @Override
    public ViewPropertyAnimator x(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.x(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator xBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.xBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator y(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.y(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator yBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.yBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator rotation(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotation(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationX(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationX(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationXBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationXBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationY(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationY(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator rotationYBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.rotationYBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator translationX(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.translationX(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator translationXBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.translationXBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator translationY(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.translationY(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator translationYBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.translationYBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleX(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleX(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleXBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleXBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleY(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleY(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator scaleYBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.scaleYBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator alpha(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.alpha(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator alphaBy(float value) {
        android.view.ViewPropertyAnimator n = mNative.get();
        if (n != null) {
            n.alphaBy(value);
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator withLayer() {
        final View v = mView.get();
        if (v != null) {
            mPendingSetupAction = new Runnable() {
                @Override
                public void run() {
                    v.setLayerType(View.LAYER_TYPE_HARDWARE, null);
                }
            };
            final int currentLayerType = v.getLayerType();
            mPendingCleanupAction = new Runnable() {
                @Override
                public void run() {
                    v.setLayerType(currentLayerType, null);
                }
            };
            if (mAnimatorSetupMap == null) {
                mAnimatorSetupMap = new HashMap<android.animation.Animator, Runnable>();
            }
            if (mAnimatorCleanupMap == null) {
                mAnimatorCleanupMap = new HashMap<android.animation.Animator, Runnable>();
            }
        }

        return this;
    }

    @Override
    public ViewPropertyAnimator withStartAction(Runnable runnable) {
        View v = mView.get();
        if (v != null) {
            mPendingOnStartAction = runnable;
            if (runnable != null && mAnimatorOnStartMap == null) {
                mAnimatorOnStartMap = new HashMap<android.animation.Animator, Runnable>();
            }
        }
        return this;
    }

    @Override
    public ViewPropertyAnimator withEndAction(Runnable runnable) {
        View v = mView.get();
        if (v != null) {
            mPendingOnEndAction = runnable;
            if (runnable != null && mAnimatorOnEndMap == null) {
                mAnimatorOnEndMap = new HashMap<android.animation.Animator, Runnable>();
            }
        }
        return this;
    }

    private void startAnimation() {
        if (mPendingSetupAction != null) {
          mAnimatorSetupMap.put(animator, mPendingSetupAction);
          mPendingSetupAction = null;
        }
        if (mPendingCleanupAction != null) {
          mAnimatorCleanupMap.put(animator, mPendingCleanupAction);
          mPendingCleanupAction = null;
        }
        if (mPendingOnStartAction != null) {
          mAnimatorOnStartMap.put(animator, mPendingOnStartAction);
          mPendingOnStartAction = null;
        }
        if (mPendingOnEndAction != null) {
          mAnimatorOnEndMap.put(animator, mPendingOnEndAction);
          mPendingOnEndAction = null;
        }
    }

    private class AnimatorEventListener implements android.animation.Animator.AnimatorListener {
        @Override
        public void onAnimationStart(android.animation.Animator animation) {
            if (mAnimatorSetupMap != null) {
                Runnable r = mAnimatorSetupMap.get(animation);
                if (r != null) {
                    r.run();
                }
            }
            if (mAnimatorOnStartMap != null) {
                Runnable r = mAnimatorOnStartMap.get(animation);
                if (r != null) {
                    r.run();
                }
            }
            if (mListener != null) {
                mListener.onAnimationStart(animation);
            }
        }

        @Override
        public void onAnimationCancel(android.animation.Animator animation animation) {
            if (mListener != null) {
                mListener.onAnimationCancel(animation);
            }
            if (mAnimatorOnEndMap != null) {
                mAnimatorOnEndMap.remove(animation);
            }
        }

        @Override
        public void onAnimationRepeat(android.animation.Animator animation animation) {
            if (mListener != null) {
                mListener.onAnimationRepeat(animation);
            }
        }

        @Override
        public void onAnimationEnd(android.animation.Animator animation animation) {
            if (mListener != null) {
                mListener.onAnimationEnd(animation);
            }
            if (mAnimatorOnEndMap != null) {
                Runnable r = mAnimatorOnEndMap.get(animation);
                if (r != null) {
                  r.run();
                }
            }
            if (mAnimatorCleanupMap != null) {
                Runnable r = mAnimatorCleanupMap.get(animation);
                if (r != null) {
                  r.run();
                }
            }
        }
    }
}
