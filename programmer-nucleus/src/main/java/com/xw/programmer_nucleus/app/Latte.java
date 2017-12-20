package com.xw.programmer_nucleus.app;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by nazi on
 * date： 2017/12/1
 */

public final class Latte {


    public static Configurator init(Context context) {
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(), context.getApplicationContext());
        return Configurator.getInstance();

    }
    public static HashMap<Object, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
    public static Context getApplicationContext(){
        return (Context) getConfigurations().get(ConfigKeys.APPLICATION_CONTEXT.name());

    }

}
