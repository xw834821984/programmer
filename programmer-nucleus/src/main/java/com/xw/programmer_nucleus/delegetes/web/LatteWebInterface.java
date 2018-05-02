package com.xw.programmer_nucleus.delegetes.web;

import android.webkit.JavascriptInterface;

import com.alibaba.fastjson.JSON;
import com.xw.programmer_nucleus.delegetes.web.event.Event;
import com.xw.programmer_nucleus.delegetes.web.event.EventManager;

/**
 * Created by nazi on
 * date： 2018/1/26
 * 跟原生web交互
 */

final class LatteWebInterface {

    private final WebDelegate DELEGATE;

    private  LatteWebInterface(WebDelegate delegate) {
        DELEGATE = delegate;
    }

    static LatteWebInterface create(WebDelegate delegate){
        return new LatteWebInterface(delegate);
    }

    @SuppressWarnings("unused")
    @JavascriptInterface
    public String event(String params){
        final String action = JSON.parseObject(params).getString("action");
        final Event event = EventManager.getInstance().createEvent(action);
        if (event !=null){
            event.setAction(action);
            event.setDelegate(DELEGATE);
            event.setContext(DELEGATE.getContext());
            event.setUrl(DELEGATE.getUrl());
            return event.execute(params);
        }
        return null;
    }
}
