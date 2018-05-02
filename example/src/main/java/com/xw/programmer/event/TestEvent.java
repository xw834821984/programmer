package com.xw.programmer.event;

import android.webkit.WebView;
import android.widget.Toast;

import com.xw.programmer_nucleus.delegetes.web.event.Event;

/**
 * Created by nazi on
 * date： 2018/3/20
 */

public class TestEvent extends Event {
    @Override
    public String execute(String params) {
        Toast.makeText(getContext(),getAction(),Toast.LENGTH_LONG).show();
        if (getAction().equals("test")){
            final WebView webView = getWebView();
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.evaluateJavascript("nativeCall;",null);
                }
            });
        }
        return null;
    }
}
