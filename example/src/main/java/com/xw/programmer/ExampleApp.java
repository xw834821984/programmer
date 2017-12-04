package com.xw.programmer;

import android.app.Application;

import com.xw.programmer_nucleus.app.Latte;

/**
 * Created by nazi on
 * date： 2017/12/1
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }

}
