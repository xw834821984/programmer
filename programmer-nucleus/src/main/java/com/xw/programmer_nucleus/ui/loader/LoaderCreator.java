package com.xw.programmer_nucleus.ui.loader;

import android.content.Context;

import com.wang.avi.AVLoadingIndicatorView;
import com.wang.avi.Indicator;

import java.util.WeakHashMap;

/**
 * Created by nazi on
 * date： 2017/12/8
 */

/*
* LoadingIndicatorView
* 官方的加载方式是通过反射加载loade的名字来加载loade
* 每次请求都要去反射一次的话性能优点堪忧
* */
public final class LoaderCreator {

    private static final WeakHashMap<String, Indicator> LOADING_MAP = new WeakHashMap<>();

    static AVLoadingIndicatorView create(String type, Context context) {

        final AVLoadingIndicatorView avLoadindicatorView = new AVLoadingIndicatorView(context);

        if (LOADING_MAP.get(type) == null) {
            final Indicator indicator = getIndicator(type);
            LOADING_MAP.put(type, indicator);

        }
        avLoadindicatorView.setIndicator(LOADING_MAP.get(type));
        return avLoadindicatorView;
    }

    private static Indicator getIndicator(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }
        final StringBuffer drawableClassName = new StringBuffer();

        if (!name.contains(".")) {
            final String defultPackageName = AVLoadingIndicatorView.class.getPackage().getName();

            drawableClassName
                    .append(defultPackageName)
                    .append(".indicators")
                    .append(".");
        }
        drawableClassName.append(name);
        try {
            final Class<?> drawableClass = Class.forName(drawableClassName.toString());

            return (Indicator) drawableClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


