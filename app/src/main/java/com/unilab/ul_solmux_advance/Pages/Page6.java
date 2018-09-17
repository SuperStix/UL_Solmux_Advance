package com.unilab.ul_solmux_advance.Pages;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.unilab.ul_solmux_advance.Exiter;
import com.unilab.ul_solmux_advance.R;
import com.unilab.ul_solmux_advance.Utils.SimpleGestureFilter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Page6 extends Activity implements SimpleGestureFilter.SimpleGestureListener {

    private SimpleGestureFilter detector;
    Dialog dialogViewer;
    Context context;
    MediaPlayer matrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_6);
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

    @OnClick({ R.id.ll_home, R.id.ll_tbl_a, R.id.ll_tbl_b, R.id.ll_tbl_c})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                startActivity(new Intent(this, Page1.class));
                break;
            case R.id.ll_tbl_a:
                graphViewer(0);
                break;
            case R.id.ll_tbl_b:
                graphViewer(1);
                break;
            case R.id.ll_tbl_c:
                graphViewer(2);
                break;
        }
    }


    //dialog_view--------------------------------
    public void graphViewer(int graph) {
        dialogViewer = new Dialog(context);
        dialogViewer.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialogViewer.setCancelable(true);
        dialogViewer.setContentView(R.layout.graph_viewer);
        dialogViewer.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        dialogViewer.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        ImageView imgGraph = (ImageView) dialogViewer.findViewById(R.id.img_graph);
        try {
            switch (graph) {
                case 0:
                    imgGraph.setImageResource(R.drawable.graph_a);
                    break;
                case 1:
                    imgGraph.setImageResource(R.drawable.graph_b);
                    break;
                case 2:
                    imgGraph.setImageResource(R.drawable.graph_c);
                    break;
            }
        } catch (Exception e) {
            Log.e("Error: ", e.toString());
        }

        imgGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogViewer.cancel();
            }
        });

        dialogViewer.show();
    }
//---------------------------------------------------------------------

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
                startActivity(new Intent(this, Page7.class));
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


}
