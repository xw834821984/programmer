package com.xw.programmer;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.xw.programmer.ec.database.DatabaseManager;
import com.xw.programmer.ec.icon.FontEcModule;
import com.xw.programmer_nucleus.app.Latte;
import com.xw.programmer_nucleus.net.interceptors.DebugInterceptor;
import com.xw.programmer_nucleus.util.AlertToast;

/**
 * Created by nazi on
 * date： 2017/12/1
 *
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withLoaderDelayed(1000)
                .withApiHost("http://192.168.151.248:80/RestServer/api/")
                .withInterceptor(new DebugInterceptor("test",R.raw.test))
                //微信
                .withWeChatAppId("")
                .withWeChatAppSecret("")
                .configure();


        DatabaseManager.getInstance().init(this);
        //初始化吐司工具
        AlertToast.init(this);


    }






}
