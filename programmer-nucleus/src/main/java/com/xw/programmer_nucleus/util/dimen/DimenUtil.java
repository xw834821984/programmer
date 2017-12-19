package com.xw.programmer_nucleus.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.xw.programmer_nucleus.app.Latte;

/**
 * Created by nazi on
 * date： 2017/12/11
 * 获取屏幕宽高
 */

public class DimenUtil {
    /*
    * 获取屏幕的宽
    * */
    public static int getScreenWidth(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.widthPixels;
    }

    /*
    * 获取屏幕的高
    * */
    public static int getScreenHeight(){
        final Resources resources = Latte.getApplicationContext().getResources();
        final DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return displayMetrics.heightPixels;
    }
}
