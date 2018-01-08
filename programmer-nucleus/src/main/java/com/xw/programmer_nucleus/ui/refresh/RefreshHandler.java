package com.xw.programmer_nucleus.ui.refresh;

import android.support.v4.widget.SwipeRefreshLayout;

import com.xw.programmer_nucleus.app.Latte;

/**
 * Created by nazi on
 * date： 2018/1/8
 * 刷新助手
 */

public class RefreshHandler implements SwipeRefreshLayout.OnRefreshListener {

    private final SwipeRefreshLayout REFRESH_LAYOUT;

    public RefreshHandler(SwipeRefreshLayout REFRESH_LAYOUT) {
        this.REFRESH_LAYOUT = REFRESH_LAYOUT;
        REFRESH_LAYOUT.setOnRefreshListener(this);
    }


    private void refresh() {
        //开始加载
        REFRESH_LAYOUT.setRefreshing(true);
        Latte.getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //网络请求
                REFRESH_LAYOUT.setRefreshing(false);
            }
        },2000);
    }

    @Override
    public void onRefresh() {

        refresh();
    }
}
