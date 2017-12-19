package com.xw.programmer_nucleus.net;

import com.xw.programmer_nucleus.app.ConfigType;
import com.xw.programmer_nucleus.app.Latte;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by nazi on
 * date： 2017/12/7
 * 创建rest
 * <p>
 * <p>
 * /**
 * 参数容器
 */

public class RestCreator {

    private static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();

    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;

    }


    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class RetrofitHolder {

        private static final String BASE_URL = (String) Latte.getConfigurations().get(ConfigType.API_HOST.name());

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OKHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

    }

    /*、ok 惰性初始化*/
    private static final class OKHttpHolder {
        private static final int TIME_OUt = 60;
        //同样是建造者模式
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUt, TimeUnit.SECONDS)
                .build();


    }


    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE =
                RetrofitHolder.RETROFIT_CLIENT.create(RestService.class);
    }
}
