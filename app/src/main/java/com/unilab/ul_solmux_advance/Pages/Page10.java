package com.unilab.ul_solmux_advance.Pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.unilab.ul_solmux_advance.Exiter;
import com.unilab.ul_solmux_advance.R;
import com.unilab.ul_solmux_advance.Utils.SimpleGestureFilter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Page10 extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    Context context;
    MediaPlayer matrix;

    public static int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_10);
        ButterKnife.bind(this);

        context = this;
        detector = new SimpleGestureFilter(this, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        matrix = MediaPlayer.create(getApplicationContext(), R.raw.matrix);
        matrix.start();
        matrix.setLooping(true);
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
                startActivity(new Intent(this, Page1.class));
                matrix.release();
                break;

            case SimpleGestureFilter.SWIPE_RIGHT:
                //TODO: proceed to the previous screen of each sub-menu (SBR-04, SBR-05, SBR-07, SBR-08, and SBR-09).
                switch (page)
                {
                    case 0:
                        startActivity(new Intent(this, Page4.class));
                        matrix.release();
                        break;
                    case 1:
                        startActivity(new Intent(this, Page5.class));
                        matrix.release();
                        break;
                    case 2:
                        startActivity(new Intent(this, Page7.class));
                        matrix.release();
                        break;
                    case 3:
                        startActivity(new Intent(this, Page8.class));
                        matrix.release();
                        break;
                    case 4:
                        startActivity(new Intent(this, Page9.class));
                        matrix.release();
                        break;
                }
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
