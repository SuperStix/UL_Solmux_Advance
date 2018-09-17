package com.unilab.ul_solmux_advance.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.unilab.ul_solmux_advance.Exiter;
import com.unilab.ul_solmux_advance.R;
import com.unilab.ul_solmux_advance.Utils.SimpleGestureFilter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Page8 extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    @BindView(R.id.iv_solmux)
    ImageView ivSolmux;

    private SimpleGestureFilter detector;
    Context context;
    Animation fade_in, fade_out;
    MediaPlayer matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_8);
        ButterKnife.bind(this);

        context = this;
        detector = new SimpleGestureFilter(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        textAnimation();
        matrix = MediaPlayer.create(getApplicationContext(), R.raw.matrix);
        matrix.start();
        matrix.setLooping(true);
    }

    private void textAnimation() {
        fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        ivSolmux.startAnimation(fade_in);

        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fade_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);
                ivSolmux.startAnimation(fade_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            case SimpleGestureFilter.SWIPE_LEFT:
                Page10.page = 3;
                startActivity(new Intent(this, Page10.class));
                matrix.release();
                break;

            case SimpleGestureFilter.SWIPE_RIGHT:
                startActivity(new Intent(this, Page1.class));
                matrix.release();
                break;
        }
    }

    @Override
    public void onDoubleTap() {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        final Intent relaunch = new Intent(this, Exiter.class)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                        | Intent.FLAG_ACTIVITY_CLEAR_TASK
                        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        startActivity(relaunch);
    }

    @Override
    public void onPause()
    {
        super.onPause();
        matrix.release();
    }


    @OnClick(R.id.ll_home)
    public void onViewClicked() {
        startActivity(new Intent(this, Page1.class));
    }
}
