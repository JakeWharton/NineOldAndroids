Change Log
==========

Version 2.1.0 *(In Development)*
--------------------------------

 * Added 'ViewPropertyAnimator` compatibility implementation. See the
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
