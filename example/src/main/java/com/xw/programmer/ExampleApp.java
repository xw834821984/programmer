package com.xw.programmer;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.xw.programmer.ec.icon.FontEcModule;
import com.xw.programmer.util.AlertToast;
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
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
               .withApiHost("http://127.0.0.1/")
                .configure();
        //初始化吐司工具
        AlertToast.init(this);
    }

}
