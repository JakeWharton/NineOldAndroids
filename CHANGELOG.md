Change Log
==========

Version 2.4.0 *(2012-06-24)*
----------------------------

 * Add `ViewHelper` class which will delegate new `View` property calls to
   their native counterparts when available.
 * Fix: Do not invalidate parent if view is not attached to anything.
 * Fix: Respect pivot for both scaling in addition to rotating.


Version 2.3.0 *(2012-04-25)*
----------------------------

 * Intelligent invalidation of parent view will only cause a redraw of the
   parts that have changed. *(Thanks to Florent Pillet)*
 * Maintain weak reference to animated view so that we do not prevent it from
   being garbage collected.
 * Ensure animation remains possible if view was removed from its parent at
   some point.
 * Fix memory leaks that may occur in some situations keeping hard references
   to views after they were no longer needed.
 * Allow reflection on private methods to mirror the JNI behavior.
 * Avoid type conflict on some devices when loading animations from XML.


Version 2.2.0 *(2012-01-30)*
----------------------------

 * Provide a feature-complete implementation of `ViewPropertyAnimator` for
   Honeycomb which previously did not offer the full API of the Android 4.0+
   version.


Version 2.1.1 *(2012-01-27)*
----------------------------

 * Fix `StackOverflowError` when using `AnimatorProxy` on pre-3.0 devices.


Version 2.1.0 *(2012-01-26)*
----------------------------

 * Added `ViewPropertyAnimator` compatibility implementation. See the
   'ViewPropertyAnimator Demo' sample for usage.
 * `AnimatorProxy` will now return a previous instance is one has already
   been created for the specified `View`.


Version 2.0.1 *(2012-01-18)*
----------------------------

 * Rotation and scale animation now mirrors the native counterpart behavior.
 * Add 'Toggles' sample.


Version 2.0.0 *(2012-01-18)*
----------------------------

Animation classes are now under the `com.nineoldandroids.animation` package.

 * `ObjectAnimator` will now automatically use a compatibility implementation
   when animating any post-3.0 view property. The following properties are
   supported: `alpha`, `translationX`, `translationY`, `scaleX`, `scaleY`,
   `x`, `y`, `rotation`, `rotationX`, `rotationY`, `pivotX`, `pivotY`,
   `scrollX`, and `scrollY`.
 * Add `AnimationProxy` which allows for wrapping any `View` to enable
   alpha, translation, scale, and rotation animation.
 * Add 'Path Animation' demo to samples.
 * Enable property animation. This requires `com.nineoldandroids.util.Property`
   and not the native variant, however.


Version 1.1.0 *(2011-12-13)*
----------------------------

 * Add `AnimatorInflater` class.
 * Add 'Droid Flakes' demo to samples.


Version 1.0.0 *(2011-12-08)*
----------------------------

Initial release.
