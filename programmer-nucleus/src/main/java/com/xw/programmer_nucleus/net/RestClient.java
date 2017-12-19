package com.xw.programmer_nucleus.net;

import android.content.Context;

import com.xw.programmer_nucleus.net.Callback.IError;
import com.xw.programmer_nucleus.net.Callback.IFailure;
import com.xw.programmer_nucleus.net.Callback.IRequest;
import com.xw.programmer_nucleus.net.Callback.ISuccess;
import com.xw.programmer_nucleus.net.Callback.RequestCallbacks;
import com.xw.programmer_nucleus.ui.LatteLoader;
import com.xw.programmer_nucleus.ui.LoaderStyle;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;


import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by nazi on
 * date： 2017/12/7
 * 具体网络请求实现类
 */

public class RestClient {

    /*网络框架要灵活需要用什么设计模式比较好，
    * 既然是传入参数有没有什么顺序要求
    * 是传入什么用什么的话
    * 建造者模式是最好的
    * 建造者模式又有两种一种是标准的建造者模式，跟安卓简化的建造者模式
    *
    * */


    private final String URl;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final Context CONTEXT;
    private final File FILE;
    private final LoaderStyle LOADER_STYLE;

    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      LoaderStyle loaderStyle,
                      File file,
                      Context context) {
        this.URl = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.CONTEXT = context;
        this.FILE = file;
        this.LOADER_STYLE = loaderStyle;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        if (LOADER_STYLE != null){
            LatteLoader.showLoading(CONTEXT,LOADER_STYLE);
        }


        switch (method) {

            case GET:
                call = service.get(URl, PARAMS);
                break;
            case POST:
                call = service.post(URl, PARAMS);
                break;
            case PUT:
                call = service.put(URl, PARAMS);
                break;
            case DELETE:
                call = service.delete(URl, PARAMS);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequstCallback());
        }

    }


    private Callback<String> getRequstCallback(){
        return  new RequestCallbacks(
                REQUEST,
                SUCCESS,
                FAILURE,
                ERROR,
                LOADER_STYLE
        );
    }


    public final void get(){
        request(HttpMethod.GET);
    }
    public final void post(){
        request(HttpMethod.POST);
    }
    public final void put(){
        request(HttpMethod.PUT);
    }
    public final void delete(){
        request(HttpMethod.DELETE);
    }
}
