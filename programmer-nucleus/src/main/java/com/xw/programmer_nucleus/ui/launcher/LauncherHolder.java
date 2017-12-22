package com.xw.programmer_nucleus.ui.launcher;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bigkoo.convenientbanner.holder.Holder;

/**
 * Created by nazi on
 * date： 2017/12/22
 */

public class LauncherHolder implements Holder<Integer> {
    private AppCompatImageView mImageView = null;

    @Override
    public View createView(Context context) {
        mImageView = new AppCompatImageView(context);

        return mImageView;
    }

    @Override
    public void UpdateUI(Context context, int position, Integer data) {

        //占据整个屏幕
        mImageView.setBackgroundResource(data);
    }
}
