package com.xw.programmer_nucleus.util.timer;

import java.util.TimerTask;

/**
 * Created by nazi on
 * date： 2017/12/21
 */

public class BaseTimerTask extends TimerTask{
    private  ITimerListener mITimerListener = null;

    public BaseTimerTask(ITimerListener timerListener){
        this.mITimerListener = timerListener;
    }
    @Override
    public void run() {

        if (mITimerListener != null){
            mITimerListener.onTimer();
        }
    }
}
