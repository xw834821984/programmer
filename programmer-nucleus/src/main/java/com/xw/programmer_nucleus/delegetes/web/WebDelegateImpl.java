package com.xw.programmer_nucleus.delegetes.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xw.programmer_nucleus.delegetes.IPageLoadListener;
import com.xw.programmer_nucleus.delegetes.web.chromeclient.WebChromeClientImpl;
import com.xw.programmer_nucleus.delegetes.web.client.WebViewClientImpl;
import com.xw.programmer_nucleus.delegetes.web.route.RouteKeys;
import com.xw.programmer_nucleus.delegetes.web.route.Router;

/**
 * Created by nazi on
 * date： 2018/3/14
 */

public class WebDelegateImpl extends WebDelegate {
    private IPageLoadListener mIPageLoadListener = null;


    public static WebDelegateImpl create(String url) {
        final Bundle args = new Bundle();
        args.putString(RouteKeys.URL.name(), url);
        final WebDelegateImpl delegate = new WebDelegateImpl();
        delegate.setArguments(args);
        return delegate;
    }


    @Override
    public Object setLayout() {
        return getWebView();
    }

    public void setPageLoadListener(IPageLoadListener listener) {
        this.mIPageLoadListener = listener;

    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

        if (getUrl() != null) {
            //用原生的方式模拟web跳转并进行页面加载
            Router.getInstance().loadPage(this, getUrl());
        }
    }

    @Override
    public IWebViewInitializer setInitializer() {
        return this;
    }

    @Override
    public WebView initWebView(WebView webView) {
        return new WebViewInitializer().createWebView(webView);
    }

    @Override
    public WebViewClient initWebViewClicent() {
        final WebViewClientImpl client = new WebViewClientImpl(this);
        client.setPageLoadListener(mIPageLoadListener);
        return client;
    }

    @Override
    public WebChromeClient initWebChromeClient() {
        return new WebChromeClientImpl();
    }
}
