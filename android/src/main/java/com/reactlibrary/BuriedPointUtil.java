package com.reactlibrary;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.widget.ContentFrameLayout;

import com.facebook.react.views.text.ReactTextView;
import com.reactlibrary.view.BuryPointView;
import com.reactlibrary.view.CoverTextView;

public class BuriedPointUtil {

    public static final String TAG = "BuriedPointUtil" ;

    public static void showBuriedOverPoint(final Activity activity, boolean isShow){
        activity.runOnUiThread(() -> {
            View decorView = activity.getWindow().getDecorView();
            ContentFrameLayout contentParent = (ContentFrameLayout) decorView.findViewById(android.R.id.content);
            if (isShow) {
                ReactTextView textView = new BuryPointView(activity);
                textView.setOnClickListener(v -> {
                    View view = activity.getWindow().getDecorView();
                    showCoverLayerView(activity,view, true);
                });
                contentParent.addView(textView); //把View添加到contentParent中
            } else {
                int childCount = contentParent.getChildCount();
                for (int i = childCount - 1; i >= 0; i--) {
                    View child = contentParent.getChildAt(i);
                    if ("bury-button".equals(child.getTag())) {
                        contentParent.removeView(child);
                    }

                }
                View view = activity.getWindow().getDecorView();
                showCoverLayerView(activity,view, false);
            }
        });
    }

    private static void showCoverLayerView(Activity activity,View view,boolean isShow){
        if (view instanceof ViewGroup) {
            ViewGroup vp = (ViewGroup) view;
            int childCount = vp.getChildCount();
            for (int i = childCount - 1; i >= 0; i--) {
                View viewChild = vp.getChildAt(i);

                Object childTag = viewChild.getTag();
                if (isShow) {
//                    if (viewChild.hasOnClickListeners() && !"bury-button".equals(childTag) ) {
                    if (childTag != null && !"".equals(childTag) && !"bury-button".equals(childTag)) {
                        Log.d(TAG, "getAllChildViews: "+viewChild.getLeft()+" "+viewChild.getTop()+" "+viewChild.getRight()+" "+viewChild.getBottom());
                        activity.runOnUiThread(() -> {
                            View insertView = new CoverTextView(activity, viewChild, 123);
                            vp.addView(insertView);
                        });
                    }
                }
                if (!isShow && childTag != null && String.valueOf(childTag).contains("-cover")) {
                    vp.removeView(viewChild);
                }

                showCoverLayerView(activity,viewChild, isShow);
            }
        }
    }

}
