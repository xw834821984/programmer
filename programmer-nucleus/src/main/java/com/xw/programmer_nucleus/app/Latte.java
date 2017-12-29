package com.xw.programmer_nucleus.app;

import android.content.Context;

/**
 * Created by nazi on
 * date： 2017/12/1
 */

public final class Latte {

    public static Configurator init(Context context) {
        Configurator.getInstance()
                .getLatteConfigs()
                .put(ConfigKeys.APPLICATION_CONTEXT, context.getApplicationContext());
        return Configurator.getInstance();
    }

    public static Configurator getConfigurator() {
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key) {
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext() {
        return getConfiguration(ConfigKeys.APPLICATION_CONTEXT);
    }

   /* public static Handler getHandler() {
        return getConfiguration(ConfigKeys.HANDLER);
    }*/

    public static void test(){
    }
}