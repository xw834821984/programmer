package com.xw.programmer_nucleus.delegetes.web;

import android.annotation.SuppressLint;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by nazi on
 * date： 2018/3/15
 */

public class WebViewInitializer {

    @SuppressLint("SetJavaScriptEnabled")
    public WebView createWebView(WebView webView){
        //安卓4.9以上
        WebView.setWebContentsDebuggingEnabled(true);

        //不能横向滚动
        webView.setHorizontalScrollBarEnabled(false);
        //不能纵向滚动
        webView.setVerticalScrollBarEnabled(false);
        //允许截屏
        webView.setDrawingCacheEnabled(true);

        //屏蔽长按事件
        webView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });
        //初始化webSettings
        final WebSettings settings = webView.getSettings();

        settings.setJavaScriptEnabled(true);

        final String ua = settings.getUserAgentString();
        settings.setUserAgentString(ua+"Latte");
        //隐藏缩放控件
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);

        //禁止缩放
        settings.setSupportZoom(false);
        //文件权限
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        //缓存相关
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

        return webView;
    }
}
