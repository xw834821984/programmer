package com.xw.programmer.ec.detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xw.programmer.ec.R;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;

import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

/**
 * Created by nazi on
 * date： 2018/1/18
 */

public class GoodsDetailDelegate extends LatteDelegate {

    public static GoodsDetailDelegate create() {
        return new GoodsDetailDelegate();
    }

    @Override
    public Object setLayout() {
        return R.layout.delegate_goods_detail;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

    }

    //跳转动画
    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        //纵向动画
        return new DefaultHorizontalAnimator();
    }
}
