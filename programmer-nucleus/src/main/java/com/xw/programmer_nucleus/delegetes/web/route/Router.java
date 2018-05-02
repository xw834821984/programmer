package com.xw.programmer_nucleus.delegetes.web.route;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.webkit.URLUtil;
import android.webkit.WebView;

import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.delegetes.web.WebDelegate;
import com.xw.programmer_nucleus.delegetes.web.WebDelegateImpl;

/**
 * Created by nazi on
 * date： 2018/3/14
 * 内容拦截
 */

public class Router {

    private Router() {

    }

    private static class Holder {
        private static final Router INSTANCE = new Router();
    }

    public static Router getInstance() {
        return Holder.INSTANCE;
    }

    //处理url

    public final boolean handleWebUrl(WebDelegate delegate, String url) {
        //如果是一个电话协议
        if (url.contains("tel:")) {
            callPhone(delegate.getContext(), url);
            return true;
        }
        final LatteDelegate topDelegate = delegate.getTopDelegate();

        final WebDelegateImpl webDelegate = WebDelegateImpl.create(url);

        topDelegate.start(webDelegate);

        return true;

    }

    /*
        * web页面load的方法
    * */

    private void loadWebPage(WebView webView, String url) {
        if (webView != null) {
            webView.loadUrl(url);
        } else {
            throw new NullPointerException("WebView is null");
        }
    }

    private void loadLocalPage(WebView webView, String url) {
        loadWebPage(webView,"file:///android_asset/"+url);
    }

    private void loadPage(WebView webView, String url){
        if (URLUtil.isNetworkUrl(url) || URLUtil.isAssetUrl(url)){
            loadWebPage(webView,url);
        }else {
            loadLocalPage(webView,url);
        }
    }

    public final void loadPage(WebDelegate delegate,String url){
        loadPage(delegate.getWebView(),url);

    }

    private void callPhone(Context context, String uri) {
        //提醒用户需要拨打电话
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        final Uri data = Uri.parse(uri);
        intent.setData(data);
        ContextCompat.startActivity(context, intent, null);
    }
}
