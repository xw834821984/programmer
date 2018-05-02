package com.xw.programmer_nucleus.delegetes.web;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.xw.programmer_nucleus.app.ConfigKeys;
import com.xw.programmer_nucleus.app.Latte;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.delegetes.web.route.RouteKeys;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * Created by nazi on
 * date： 2018/1/26
 * 沉载web页面的基础核心
 */

public abstract class WebDelegate extends LatteDelegate implements IWebViewInitializer{

    private WebView mWebView = null;
    private final ReferenceQueue<WebView> WEB_VIEW_QUEUE = new ReferenceQueue<>();
    private String mUrl = null;
    private boolean mIsWebViewAvailable = false;
    private LatteDelegate mTopDelegate = null;

    public WebDelegate() {
    }

    public abstract IWebViewInitializer setInitializer();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        mUrl = args.getString(RouteKeys.URL.name());

        initWebView();
    }

    private void initWebView() {
        if (mWebView != null) {
            mWebView.removeAllViews();
            mWebView.destroy();

        } else {
            final IWebViewInitializer initializer = setInitializer();
            if (initializer != null) {
                //这里直接new出webview
                //因为webview直接写在xml文件里面的话，这样容易照成内存泄露，在代码中直接new 可以避免泄露
                final WeakReference<WebView> webViewWeakReference =
                        new WeakReference<>(new WebView(getContext()), WEB_VIEW_QUEUE);
                mWebView = webViewWeakReference.get();
                mWebView = initializer.initWebView(mWebView);
                mWebView.setWebViewClient(initializer.initWebViewClicent());
                mWebView.setWebChromeClient(initializer.initWebChromeClient());
                final String name = Latte.getConfiguration(ConfigKeys.JAVASCRIPT_INTERFACE);
                mWebView.addJavascriptInterface(LatteWebInterface.create(this), name);
                mIsWebViewAvailable = true;
            } else {
                throw new NullPointerException("Initializer is null");
            }

        }
    }

    public void setTopDelegate (LatteDelegate delegate){
        mTopDelegate = delegate;
    }

    public LatteDelegate getTopDelegate(){
        if (mTopDelegate == null){
            mTopDelegate = this;
        }
        return mTopDelegate;
        }

    public WebView getWebView() {

        if (mWebView == null){
            throw  new NullPointerException("WebView is null");
        }
        return mIsWebViewAvailable ? mWebView :null;
    }

    public String getUrl(){
        if (mUrl == null){
            throw  new NullPointerException("mUrl is null");
        }
        return mUrl;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mWebView != null) {
            mWebView.onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mWebView != null) {
            mWebView.onResume();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsWebViewAvailable = false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mWebView != null) {
            mWebView.removeAllViews();
            mWebView.destroy();
            mWebView = null;
        }
    }
}
