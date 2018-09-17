package com.unilab.ul_solmux_advance.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class Page1 extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    @BindView(R.id.iv_capsule)
    ImageView ivCapsule;

    private SimpleGestureFilter detector;

    Animation fade_in;
    Context context;
    MediaPlayer matrix;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_1);
        ButterKnife.bind(this);

        context = this;
        detector = new SimpleGestureFilter(this, this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        capsuleAnimation();
        matrix = MediaPlayer.create(getApplicationContext(), R.raw.matrix);
        matrix.start();
        matrix.setLooping(true);
    }

    private void capsuleAnimation() {
        fade_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        ivCapsule.startAnimation(fade_in);
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

    @OnClick({R.id.ll_price_1, R.id.ll_price_2, R.id.ll_price_3, R.id.ll_respiratory_1, R.id.ll_respiratory_2, R.id.ll_respiratory_3, R.id.ll_respiratory_4
            , R.id.ll_copd_1, R.id.ll_copd_2, R.id.ll_features_1, R.id.ll_features_2, R.id.ll_features_3, R.id.ll_support_1, R.id.ll_support_3, R.id.ll_support_2, R.id.ll_support_4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_respiratory_1:
            case R.id.ll_respiratory_2:
            case R.id.ll_respiratory_3:
            case R.id.ll_respiratory_4:
                startActivity(new Intent(this, Page2.class));
//                matrix.release();
                break;
            case R.id.ll_features_1:
            case R.id.ll_features_2:
            case R.id.ll_features_3:
                startActivity(new Intent(this, Page5.class));
//                matrix.release();
                break;
            case R.id.ll_support_1:
            case R.id.ll_support_2:
            case R.id.ll_support_3:
            case R.id.ll_support_4:
                startActivity(new Intent(this, Page6.class));
//                matrix.release();
                break;
            case R.id.ll_copd_1:
            case R.id.ll_copd_2:
                startActivity(new Intent(this, Page8.class));
//                matrix.release();
                break;
            case R.id.ll_price_1:
            case R.id.ll_price_2:
            case R.id.ll_price_3:
                startActivity(new Intent(this, Page9.class));
//                matrix.release();
                break;

        }
    }
}
