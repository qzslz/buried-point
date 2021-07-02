package com.reactlibrary.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/**
 * 屏幕工具类
 */
public class ScreenUtils {

    private static WindowManager getWindowManager(Context context){
        return (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }

    /**
     * 手机屏幕真实高度
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context){
        Display display = getWindowManager(context).getDefaultDisplay();
        Point outPoint = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            // 可能有虚拟按键的情况
            display.getRealSize(outPoint);
        } else {
            // 不可能有虚拟按键
            display.getSize(outPoint);
        }
        return outPoint.y;
    }

    /**
     * 手机屏幕真实宽度
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context){
        Display display = getWindowManager(context).getDefaultDisplay();
        Point outPoint = new Point();
        if (Build.VERSION.SDK_INT >= 19) {
            // 可能有虚拟按键的情况
            display.getRealSize(outPoint);
        } else {
            // 不可能有虚拟按键
            display.getSize(outPoint);
        }
        return outPoint.x;
    }
}
