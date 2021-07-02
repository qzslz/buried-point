package com.reactlibrary.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.facebook.react.views.text.ReactTextView;
import com.reactlibrary.R;
import com.reactlibrary.utils.ScreenUtils;

public class BuryPointView extends ReactTextView {
    private static String TAG = "BuryPointView";

    private float mStartX = 0;
    private float mStartY = 0;
    private int mWidth = 200;
    private int mHeight = 200;
    private long mStartTime = 0;
    private OnClickListener mClickListener;

    public BuryPointView(Context context) {
        super(context);
        init();
    }

    private void init() {
        setText("埋点");
        setTextColor(Color.parseColor("#000000"));
        setGravity(Gravity.CENTER);
        setWidth(mWidth);
        setHeight(mHeight);
        setTag("bury-button");
        setClickable(true);
        measure(0, 0);
        setBackground(getContext().getDrawable(R.drawable.selected_bury_btn));
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.BOTTOM | Gravity.RIGHT);
        params.setMargins(0, 0, 50, 100);
        setLayoutParams(params);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mClickListener = l;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mStartTime = System.currentTimeMillis();
                mStartX = event.getX();
                mStartY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getX() - mStartX;
                float dy = event.getY() - mStartY;
                FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) getLayoutParams();
                float marginRight = Math.max(Math.min(params.rightMargin - dx, ScreenUtils.getScreenWidth(getContext()) - mWidth), 0);
                float marginBottom = Math.max(Math.min(params.bottomMargin - dy, ScreenUtils.getScreenHeight(getContext()) - mHeight), 0);
                params.setMargins(0, 0, Math.round(marginRight), Math.round(marginBottom));
                setLayoutParams(params);
                break;
            case MotionEvent.ACTION_UP:
                long endTime = System.currentTimeMillis();
                if (mClickListener != null && endTime - mStartTime < 500) {
                    mClickListener.onClick(this);
                }
                break;
        }
        return true;
    }
}
