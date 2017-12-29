package com.xw.programmer_nucleus.wechat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

/**
 * Created by nazi on
 * date： 2017/12/29
 */

public  abstract class BaseWXActivity extends AppCompatActivity implements IWXAPIEventHandler{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //必须写在oncreate 中
        LatterWeChat.getInstance().getWXAPI().handleIntent(getIntent(),this);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        //保证在其他手机上也可以使用
        LatterWeChat.getInstance().getWXAPI().handleIntent(getIntent(),this);
    }
}
