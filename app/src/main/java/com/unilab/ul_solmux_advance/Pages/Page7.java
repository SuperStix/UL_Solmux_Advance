package com.unilab.ul_solmux_advance.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.unilab.ul_solmux_advance.Exiter;
import com.unilab.ul_solmux_advance.R;
import com.unilab.ul_solmux_advance.Utils.SimpleGestureFilter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Page7 extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    @BindView(R.id.iv_germ1_control)
    ImageView ivGerm1Control;
    @BindView(R.id.iv_germ2_control)
    ImageView ivGerm2Control;
    @BindView(R.id.iv_germ1_carbocisteine)
    ImageView ivGerm1Carbocisteine;
    @BindView(R.id.iv_germ2_carbocisteine)
    ImageView ivGerm2Carbocisteine;
    @BindView(R.id.iv_germ3_carbocisteine)
    ImageView ivGerm3Carbocisteine;
    @BindView(R.id.iv_germ4_carbocisteine)
    ImageView ivGerm4Carbocisteine;
    @BindView(R.id.iv_germ1_zinc)
    ImageView ivGerm1Zinc;
    @BindView(R.id.iv_germ2_zinc)
    ImageView ivGerm2Zinc;
    @BindView(R.id.iv_germ3_zinc)
    ImageView ivGerm3Zinc;
    @BindView(R.id.iv_germ4_zinc)
    ImageView ivGerm4Zinc;
    @BindView(R.id.iv_germ5_zinc)
    ImageView ivGerm5Zinc;
    @BindView(R.id.iv_germ6_zinc)
    ImageView ivGerm6Zinc;
@BindView(R.id.iv_germ1_solmux)
    ImageView ivGerm1Solmux;
    @BindView(R.id.iv_germ2_solmux)
    ImageView ivGerm2Solmux;
    @BindView(R.id.iv_germ3_solmux)
    ImageView ivGerm3Solmux;
    @BindView(R.id.iv_germ4_solmux)
    ImageView ivGerm4Solmux;
    @BindView(R.id.iv_germ5_solmux)
    ImageView ivGerm5Solmux;
    @BindView(R.id.iv_germ6_solmux)
    ImageView ivGerm6Solmux;
    @BindView(R.id.iv_germ7_solmux)
    ImageView ivGerm7Solmux;
    @BindView(R.id.iv_germ8_solmux)
    ImageView ivGerm8Solmux;
    @BindView(R.id.iv_germ9_solmux)
    ImageView ivGerm9Solmux;
    @BindView(R.id.iv_germ10_solmux)
    ImageView ivGerm10Solmux;

    Animation germ1Anim, germ2Anim, germ3Anim, germ4Anim, germ5Anim, germ6Anim, germ7Anim, germ8Anim, germ9Anim, germ10Anim, germ11Anim, germ12Anim,germ13Anim, germ14Anim, germ15Anim, germ16Anim;
    Context context;
    private SimpleGestureFilter detector;
    MediaPlayer matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_7);
        ButterKnife.bind(this);

        context = this;
        detector = new SimpleGestureFilter(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        germsAnimation();
        matrix = MediaPlayer.create(getApplicationContext(), R.raw.matrix);
        matrix.start();
        matrix.setLooping(true);
    }

    private void germsAnimation() {
        germ1Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ1_anim);
        ivGerm1Control.startAnimation(germ1Anim);
        ivGerm3Carbocisteine.startAnimation(germ1Anim);
        ivGerm2Zinc.startAnimation(germ1Anim);

        germ2Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ2_anim);
        ivGerm2Control.startAnimation(germ2Anim);
        ivGerm4Carbocisteine.startAnimation(germ2Anim);
        ivGerm5Zinc.startAnimation(germ2Anim);

        germ3Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ3_anim);
        ivGerm1Carbocisteine.startAnimation(germ3Anim);
        ivGerm1Zinc.startAnimation(germ3Anim);

        germ4Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ4_anim);
        ivGerm2Carbocisteine.startAnimation(germ4Anim);
        ivGerm3Zinc.startAnimation(germ4Anim);

        germ5Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ5_anim);
        ivGerm4Zinc.startAnimation(germ5Anim);

        germ6Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ6_anim);
        ivGerm6Zinc.startAnimation(germ6Anim);
        //---------------
        germ7Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ7_anim);
        ivGerm5Solmux.startAnimation(germ7Anim);

        germ8Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ8_anim);
        ivGerm10Solmux.startAnimation(germ8Anim);

        germ9Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ9_anim);
        ivGerm1Solmux.startAnimation(germ9Anim);

        germ10Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ10_anim);
        ivGerm3Solmux.startAnimation(germ10Anim);

        germ11Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ11_anim);
        ivGerm6Solmux.startAnimation(germ11Anim);

        germ12Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ12_anim);
        ivGerm2Solmux.startAnimation(germ12Anim);

        germ13Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ13_anim);
        ivGerm8Solmux.startAnimation(germ13Anim);

        germ14Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ14_anim);
        ivGerm7Solmux.startAnimation(germ14Anim);

        germ15Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ15_anim);
        ivGerm9Solmux.startAnimation(germ15Anim);

        germ16Anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.germ16_anim);
        ivGerm4Solmux.startAnimation(germ16Anim);
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
                Page10.page = 2;
                startActivity(new Intent(this, Page10.class));
                matrix.release();
                break;

            case SimpleGestureFilter.SWIPE_RIGHT:
                startActivity(new Intent(this, Page6.class));
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
