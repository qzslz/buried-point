package com.reactlibrary.view;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;

import com.facebook.react.views.text.ReactTextView;
import com.reactlibrary.R;


/**
 * 蒙层
 */
public class CoverTextView extends ReactTextView {
    private static  String TAG = "CoverTextView" ;
    private View mTagView ;
    private String mValue ;
    public CoverTextView(Context context, View tagView, int count) {
        super(context);
        this.mTagView = tagView ;
        this.mValue = String.valueOf(count) ;
        init() ;
    }

    private void init(){
        setText(mValue);
        setTextColor(Color.RED);
        setTag(mTagView.getTag() + "-cover");
        setClickable(true);
        setMinHeight(mTagView.getHeight());
        setMinWidth(mTagView.getWidth());
        measure(0,0);
        layout(mTagView.getLeft(), mTagView.getTop(), mTagView.getRight(), mTagView.getBottom());
        setGravity(Gravity.CENTER);
        setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        setBackground(getContext().getDrawable(R.drawable.selected_cover_bg));
    }
}
