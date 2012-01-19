package com.jakewharton.nineoldandroids.sample;

import com.nineoldandroids.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Toggles extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toggles);

        final View target = findViewById(R.id.target);
        final int duration = 2 * 1000;

        ((Button)findViewById(R.id.tx)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "translationX", 0, 100, 0).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.ty)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "translationY", 0, 100, 0).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.sx)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "scaleX", 1, 2, 1).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.sy)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "scaleY", 1, 2, 1).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.a)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "alpha", 1, 0, 1).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.rx)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "rotationX", 0, 180, 0).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.ry)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "rotationY", 0, 180, 0).setDuration(duration).start();
            }
        });
        ((Button)findViewById(R.id.rz)).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator.ofFloat(target, "rotation", 0, 180, 0).setDuration(duration).start();
            }
        });
    }
}
