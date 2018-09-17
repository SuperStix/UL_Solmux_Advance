package com.unilab.ul_solmux_advance.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.unilab.ul_solmux_advance.Exiter;
import com.unilab.ul_solmux_advance.R;
import com.unilab.ul_solmux_advance.Utils.SimpleGestureFilter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Page2 extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    @BindView(R.id.sb_mucus)
    AppCompatSeekBar sbMucus;
    @BindView(R.id.sb_zinc)
    AppCompatSeekBar sbZinc;
    @BindView(R.id.iv_germ_1)
    ImageView ivGerm1;
    @BindView(R.id.iv_germ_2)
    ImageView ivGerm2;
    @BindView(R.id.iv_germ_3)
    ImageView ivGerm3;
    @BindView(R.id.iv_germ_4)
    ImageView ivGerm4;
    @BindView(R.id.iv_germ_5)
    ImageView ivGerm5;
    @BindView(R.id.iv_germ_6)
    ImageView ivGerm6;

    private SimpleGestureFilter detector;
    Animation germScaleTranslate1, germScaleTranslate2, germScaleTranslate3, germScaleTranslate4, germScaleTranslate5, germScaleTranslate6;
    Context context;
    MotionEvent motionEvent;
    MediaPlayer matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2);
        ButterKnife.bind(this);

        context = this;
        detector = new SimpleGestureFilter(this, this);

        sbZinc.setEnabled(false);

        setFunction();
    }

    private void setFunction() {

        sbMucus.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                detector.setEnabled(false);
                sbZinc.setProgress(100 - progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                detector.setEnabled(true);
            }
        });
        sbZinc.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                detector.setEnabled(false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                detector.setEnabled(true);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        germsAnimation();
        matrix = MediaPlayer.create(getApplicationContext(), R.raw.matrix);
        matrix.start();
        matrix.setLooping(true);
    }


    void germsAnimation() {
        germScaleTranslate1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ_scale_translate1);
        ivGerm1.startAnimation(germScaleTranslate1);

        germScaleTranslate2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ_scale_translate2);
        ivGerm2.startAnimation(germScaleTranslate2);

        germScaleTranslate3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ_scale_translate3);
        ivGerm3.startAnimation(germScaleTranslate3);

        germScaleTranslate4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ_scale_translate4);
        ivGerm4.startAnimation(germScaleTranslate4);

        germScaleTranslate5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ_scale_translate5);
        ivGerm5.startAnimation(germScaleTranslate5);

        germScaleTranslate6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ_scale_translate6);
        ivGerm6.startAnimation(germScaleTranslate6);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        this.motionEvent = me;
        Log.i("detector", String.valueOf(me.getX()) + " " + String.valueOf(me.getY()));

        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        switch (direction) {
            case SimpleGestureFilter.SWIPE_LEFT:
                Log.i("direction", String.valueOf(direction));
                startActivity(new Intent(this, Page3.class));
                matrix.release();
                break;

            case SimpleGestureFilter.SWIPE_RIGHT:
                Log.i("direction", String.valueOf(direction));
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
