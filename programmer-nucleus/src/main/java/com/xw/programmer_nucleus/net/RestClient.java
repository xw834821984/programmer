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


import okhttp3.MediaType;
import okhttp3.MultipartBody;
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


    private final String URL;
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
                      File file,
                      LoaderStyle loaderStyle,
                      Context context) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.FILE = file;
        this.CONTEXT = context;
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

        if (LOADER_STYLE != null) {

            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }
        switch (method) {

            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);

            case DELETE:
                call = service.delete(URL, PARAMS);
                break;

            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName());
                call = RestCreator.getRestService().upload(URL, body);
                break;
            default:
                break;
        }
        if (call != null) {
            call.enqueue(getRequstCallback());
        }

    }


    private Callback<String> getRequstCallback() {
        return new RequestCallbacks(
                REQUEST,
                SUCCESS,
                FAILURE,
                ERROR,
                LOADER_STYLE
        );
    }


    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }
    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);

        }
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
