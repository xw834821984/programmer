package com.xw.programmer_nucleus.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by nazi on
 * date： 2017/12/1
 */

public final class Latte {


    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();

    }

    private static WeakHashMap
            <String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}
