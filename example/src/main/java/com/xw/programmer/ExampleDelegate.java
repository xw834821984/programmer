package com.xw.programmer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.net.Callback.IError;
import com.xw.programmer_nucleus.net.Callback.IFailure;
import com.xw.programmer_nucleus.net.Callback.ISuccess;
import com.xw.programmer_nucleus.net.RestClient;

/**
 * Created by nazi on
 * date： 2017/12/6
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegater_example;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

     //   testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://127.0.0.1/index")
                .loader(getContext())
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                       Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
