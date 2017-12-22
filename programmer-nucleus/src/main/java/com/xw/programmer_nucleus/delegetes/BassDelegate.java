package com.xw.programmer_nucleus.delegetes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xw.programmer_nucleus.activities.ProxyActivitie;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by nazi on
 * date： 2017/12/5
 */


public abstract class BassDelegate extends SwipeBackFragment {

    //编译器忽略单词拼写错误
    @SuppressWarnings("SpellCheckingInspection")
    private Unbinder mUnbinder = null;

    public abstract Object setLayout();

    public abstract void onBindview(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {

            throw new ClassCastException("setLayout()类型必须是int或视图");

        }
        mUnbinder = ButterKnife.bind(this, rootView);
        onBindview(savedInstanceState, rootView);


        return rootView;
    }

    public final ProxyActivitie getProxyActivity(){
        return (ProxyActivitie) _mActivity;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            //解除绑定
            mUnbinder.unbind();
        }
    }
}
