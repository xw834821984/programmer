package com.xw.programmer_nucleus.delegetes.bottom;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.util.AlertToast;

/**
 * Created by nazi on
 * date： 2018/1/2
 * 每个页面的父类
 */

public abstract class BottomItemDelegate extends LatteDelegate implements View.OnKeyListener{

    private long mExitTime = 0;
    private  static final int EXIT_TIME = 2000;

    @Override
    public void onResume() {
        super.onResume();
        final View rootView = getView();
        if (rootView != null){
            rootView.setFocusableInTouchMode(true);
            rootView.requestFocus();
            rootView.setOnKeyListener(this);
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        //判断点击时间
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - mExitTime) > EXIT_TIME) {
                AlertToast.show("双击退出", Toast.LENGTH_SHORT);
                mExitTime = System.currentTimeMillis();
            } else {
                _mActivity.finish();
                if (mExitTime != 0) {
                    mExitTime = 0;
                }
            }
            return true;
        }
        return false;
    }

}
