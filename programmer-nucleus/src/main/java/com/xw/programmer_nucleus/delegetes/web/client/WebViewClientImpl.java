package com.xw.programmer_nucleus.delegetes.web.client;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.xw.programmer_nucleus.delegetes.IPageLoadListener;
import com.xw.programmer_nucleus.delegetes.web.WebDelegate;
import com.xw.programmer_nucleus.delegetes.web.route.Router;
import com.xw.programmer_nucleus.ui.loader.LatteLoader;
import com.xw.programmer_nucleus.util.log.LatterLogger;

/**
 * Created by nazi on
 * date： 2018/3/14
 */

public class WebViewClientImpl extends WebViewClient {

    private final WebDelegate DELEGATE;
    private IPageLoadListener mIPageLoadListener = null;


    public void setPageLoadListener (IPageLoadListener listener){
        this.mIPageLoadListener=listener;

    }

    public WebViewClientImpl(WebDelegate delegate){
        this.DELEGATE = delegate;
    }


    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        LatterLogger.d("shouldOverrideUrlLoading",url);
        return Router.getInstance().handleWebUrl(DELEGATE,url);
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        if (mIPageLoadListener !=null){
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);
        if (mIPageLoadListener !=null){
            mIPageLoadListener.onLoadStart();
        }
        LatteLoader.showLoading(view.getContext());
    }

}
