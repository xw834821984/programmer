package com.xw.programmer.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatCheckedTextView;
import android.view.View;

import com.xw.programmer.ec.R;
import com.xw.programmer.ec.R2;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.util.timer.ITimerListener;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by nazi on
 * date： 2017/12/21
 */

public class LauncherDelegate extends LatteDelegate implements ITimerListener {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatCheckedTextView mTvTimer = null;

    @OnClick(R2.id.tv_launcher_timer)
    void onCliclTimerView() {

    }

    @Override
    public Object setLayout() {


      return R.layout.dellegate_launcher;

    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onTimer() {

    }
}
