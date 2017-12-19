package com.xw.programmer_nucleus.net;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by nazi on
 * date： 2017/12/7
 */

public interface RestService {

    /*因为是通用的封装所以就传入什么执行什么*/
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);


    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);


    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    /*retrofit默认的方式就是一次性把文件下载到内存里，当你下载完后一次写到文件里
    * 这种方式容易照成内存溢出，这时候就需要加上Streaming注解，就能避免边下载边写入
    *
    * */
    @Streaming
    @GET
    Call<ResponseBody> download(@Url String url, @QueryMap Map<String, Object> params);


    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part("part") MultipartBody.Part file);

}
