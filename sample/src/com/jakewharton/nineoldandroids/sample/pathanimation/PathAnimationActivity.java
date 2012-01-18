/*
 * Copyright (C) 2012 The Android Open Source Project
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
package com.jakewharton.nineoldandroids.sample.pathanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jakewharton.nineoldandroids.sample.R;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.animation.AnimatorProxy;

public class PathAnimationActivity extends Activity {
    Button mButton;
    AnimatorProxy mButtonProxy;
    PathEvaluator mEvaluator = new PathEvaluator();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pathanimator);

        mButton = (Button) findViewById(R.id.button);
        mButtonProxy = AnimatorProxy.wrap(mButton);

        // Set up the path we're animating along
        AnimatorPath path = new AnimatorPath();
        path.moveTo(0, 0);
        path.lineTo(0, 300);
        path.curveTo(100, 0, 300, 900, 400, 500);

        // Set up the animation
        final ObjectAnimator anim = ObjectAnimator.ofObject(this, "buttonLoc",
                new PathEvaluator(), path.getPoints().toArray());
        anim.setDuration(1000);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anim.start();
            }
        });

    }

    /**
     * We need this setter to translate between the information the animator
     * produces (a new "PathPoint" describing the current animated location)
     * and the information that the button requires (an xy location). The
     * setter will be called by the ObjectAnimator given the 'buttonLoc'
     * property string.
     */
    public void setButtonLoc(PathPoint newLoc) {
        mButtonProxy.setTranslationX(newLoc.mX);
        mButtonProxy.setTranslationY(newLoc.mY);
    }

}
