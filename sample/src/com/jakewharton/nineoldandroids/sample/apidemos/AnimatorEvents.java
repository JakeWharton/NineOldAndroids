/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jakewharton.nineoldandroids.sample.apidemos;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.jakewharton.nineoldandroids.sample.R;

/**
 * This demo shows how the AnimatorListener events work.
 */
public class AnimatorEvents extends Activity {
    private static final int OFF = 0x77FFFFFF;
    private static final int ON  = 0xFFFFFFFF;

    TextView startText, repeatText, cancelText, endText;
    TextView startTextAnimator, repeatTextAnimator, cancelTextAnimator, endTextAnimator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animator_events);
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        final MyAnimationView animView = new MyAnimationView(this);
        container.addView(animView);
        startText = (TextView) findViewById(R.id.startText);
        startText.setTextColor(OFF);
        repeatText = (TextView) findViewById(R.id.repeatText);
        repeatText.setTextColor(OFF);
        cancelText = (TextView) findViewById(R.id.cancelText);
        cancelText.setTextColor(OFF);
        endText = (TextView) findViewById(R.id.endText);
        endText.setTextColor(OFF);
        startTextAnimator = (TextView) findViewById(R.id.startTextAnimator);
        startTextAnimator.setTextColor(OFF);
        repeatTextAnimator = (TextView) findViewById(R.id.repeatTextAnimator);
        repeatTextAnimator.setTextColor(OFF);
        cancelTextAnimator = (TextView) findViewById(R.id.cancelTextAnimator);
        cancelTextAnimator.setTextColor(OFF);
        endTextAnimator = (TextView) findViewById(R.id.endTextAnimator);
        endTextAnimator.setTextColor(OFF);
        final CheckBox endCB = (CheckBox) findViewById(R.id.endCB);


        Button starter = (Button) findViewById(R.id.startButton);
        starter.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                animView.startAnimation(endCB.isChecked());
            }
        });

        Button canceler = (Button) findViewById(R.id.cancelButton);
        canceler.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                animView.cancelAnimation();
            }
        });

        Button ender = (Button) findViewById(R.id.endButton);
        ender.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                animView.endAnimation();
            }
        });

    }

    public class MyAnimationView extends View implements Animator.AnimatorListener,
    ValueAnimator.AnimatorUpdateListener {

        public final ArrayList<ShapeHolder> balls = new ArrayList<ShapeHolder>();
        Animator animation;
        ShapeHolder ball = null;
        boolean endImmediately = false;

        public MyAnimationView(Context context) {
            super(context);
            ball = createBall(25, 25);
        }

        private void createAnimation() {
            if (animation == null) {
                ObjectAnimator yAnim = ObjectAnimator.ofFloat(ball, "y",
                        ball.getY(), getHeight() - 50f).setDuration(1500);
                yAnim.setRepeatCount(0);
                yAnim.setRepeatMode(ValueAnimator.REVERSE);
                yAnim.setInterpolator(new AccelerateInterpolator(2f));
                yAnim.addUpdateListener(this);
                yAnim.addListener(this);

                ObjectAnimator xAnim = ObjectAnimator.ofFloat(ball, "x",
                        ball.getX(), ball.getX() + 300).setDuration(1000);
                xAnim.setStartDelay(0);
                xAnim.setRepeatCount(0);
                xAnim.setRepeatMode(ValueAnimator.REVERSE);
                xAnim.setInterpolator(new AccelerateInterpolator(2f));

                ObjectAnimator alphaAnim = ObjectAnimator.ofFloat(ball, "alpha", 1f, .5f).
                        setDuration(1000);
                AnimatorSet alphaSeq = new AnimatorSet();
                alphaSeq.play(alphaAnim);

                animation = new AnimatorSet();
                ((AnimatorSet) animation).playTogether(yAnim, xAnim);
                animation.addListener(this);
            }
        }

        public void startAnimation(boolean endImmediately) {
            this.endImmediately = endImmediately;
            startText.setTextColor(OFF);
            repeatText.setTextColor(OFF);
            cancelText.setTextColor(OFF);
            endText.setTextColor(OFF);
            startTextAnimator.setTextColor(OFF);
            repeatTextAnimator.setTextColor(OFF);
            cancelTextAnimator.setTextColor(OFF);
            endTextAnimator.setTextColor(OFF);
            createAnimation();
            animation.start();
        }

        public void cancelAnimation() {
            createAnimation();
            animation.cancel();
        }

        public void endAnimation() {
            createAnimation();
            animation.end();
        }

        private ShapeHolder createBall(float x, float y) {
            OvalShape circle = new OvalShape();
            circle.resize(50f, 50f);
            ShapeDrawable drawable = new ShapeDrawable(circle);
            ShapeHolder shapeHolder = new ShapeHolder(drawable);
            shapeHolder.setX(x - 25f);
            shapeHolder.setY(y - 25f);
            int red = (int)(Math.random() * 255);
            int green = (int)(Math.random() * 255);
            int blue = (int)(Math.random() * 255);
            int color = 0xff000000 | red << 16 | green << 8 | blue;
            Paint paint = drawable.getPaint(); //new Paint(Paint.ANTI_ALIAS_FLAG);
            int darkColor = 0xff000000 | red/4 << 16 | green/4 << 8 | blue/4;
            RadialGradient gradient = new RadialGradient(37.5f, 12.5f,
                    50f, color, darkColor, Shader.TileMode.CLAMP);
            paint.setShader(gradient);
            shapeHolder.setPaint(paint);
            return shapeHolder;
        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.save();
            canvas.translate(ball.getX(), ball.getY());
            ball.getShape().draw(canvas);
            canvas.restore();
        }

        public void onAnimationUpdate(ValueAnimator animation) {
            invalidate();
        }

        public void onAnimationStart(Animator animation) {
            if (animation instanceof AnimatorSet) {
                startText.setTextColor(ON);
            } else {
                startTextAnimator.setTextColor(ON);
            }
            if (endImmediately) {
                animation.end();
            }
        }

        public void onAnimationEnd(Animator animation) {
            if (animation instanceof AnimatorSet) {
                endText.setTextColor(ON);
            } else {
                endTextAnimator.setTextColor(ON);
            }
        }

        public void onAnimationCancel(Animator animation) {
            if (animation instanceof AnimatorSet) {
                cancelText.setTextColor(ON);
            } else {
                cancelTextAnimator.setTextColor(ON);
            }
        }

        public void onAnimationRepeat(Animator animation) {
            if (animation instanceof AnimatorSet) {
                repeatText.setTextColor(ON);
            } else {
                repeatTextAnimator.setTextColor(ON);
            }
        }
    }
}