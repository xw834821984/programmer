package com.xw.programmer.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import com.xw.programmer.ec.R;
import com.xw.programmer.ec.R2;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.util.timer.BaseTimerTask;
import com.xw.programmer_nucleus.util.timer.ITimerListener;

import java.text.MessageFormat;
import java.util.Timer;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by nazi on
 * date： 2017/12/21
 * 启动图
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    //@BindView(R2.id.tv_launcher_timer)
    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;
    private Timer mTimer = null;

    private int mCount = 3;

    //  @OnClick(R2.id.tv_launcher_timer)
    @OnClick(R2.id.tv_launcher_timer)
    void onClickTimerView() {

        /*if (mTimer != null) {
            mTimer.cancel();
            mTimer = null;
            //  checkIsShowScroll();
        }*/
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {
        initTimer();
    }

    private void initTimer() {

        mTimer = new Timer();
        final BaseTimerTask task = new BaseTimerTask(this);
        //0： 马上开始倒计时  1000：每隔一秒处理一次
        mTimer.schedule(task, 0, 1000);
    }

    @Override
    public Object setLayout() {
        return R.layout.dellegate_launcher;
    }


    @Override
    public void onTimer() {
        getProxyActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mTvTimer != null) {
                    mTvTimer.setText(MessageFormat.format("跳过\n{0}s", mCount));
                    mCount--;
                    if (mCount < 0) {
                        if (mTvTimer != null) {
                            mTimer.cancel();
                            mTimer = null;
                        }
                    }
                }
            }
        });

    }
}
