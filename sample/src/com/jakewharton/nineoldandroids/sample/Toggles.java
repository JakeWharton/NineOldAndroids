package com.jakewharton.nineoldandroids.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;

public class Toggles extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggles);

        final View target = findViewById(R.id.target);
        final int duration = 2 * 1000;

        findViewById(R.id.tx).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "translationX", 0, 50, -50, 0).setDuration(duration).start();
            }
        });
        findViewById(R.id.ty).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "translationY", 0, 50, -50, 0).setDuration(duration).start();
            }
        });
        findViewById(R.id.sx).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "scaleX", 1, 2, 1).setDuration(duration).start();
            }
        });
        findViewById(R.id.sy).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "scaleY", 1, 2, 1).setDuration(duration).start();
            }
        });
        findViewById(R.id.a).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "alpha", 1, 0, 1).setDuration(duration).start();
            }
        });
        findViewById(R.id.rx).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "rotationX", 0, 180, 0).setDuration(duration).start();
            }
        });
        findViewById(R.id.ry).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "rotationY", 0, 180, 0).setDuration(duration).start();
            }
        });
        findViewById(R.id.rz).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "rotation", 0, 180, 0).setDuration(duration).start();
            }
        });
        findViewById(R.id.pivot_zero_zero).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHelper.setPivotX(target, 0);
                ViewHelper.setPivotY(target, 0);
            }
        });
        findViewById(R.id.pivot_center).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHelper.setPivotX(target, target.getWidth() / 2f);
                ViewHelper.setPivotY(target, target.getHeight() / 2f);
            }
        });
        findViewById(R.id.pivot_width_height).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHelper.setPivotX(target, target.getWidth());
                ViewHelper.setPivotY(target, target.getHeight());
            }
        });
    }
}
