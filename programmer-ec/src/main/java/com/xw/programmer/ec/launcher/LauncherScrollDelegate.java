package com.xw.programmer.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.xw.programmer.ec.R;
import com.xw.programmer_nucleus.delegetes.LatteDelegate;
import com.xw.programmer_nucleus.ui.launcher.LauncherHolderCreator;
import com.xw.programmer_nucleus.ui.launcher.ScrollLauncherTag;
import com.xw.programmer_nucleus.util.storage.LattePreference;

import java.util.ArrayList;

/**
 * Created by nazi on
 * date： 2017/12/22
 * 启动页
 *
 */

public class LauncherScrollDelegate extends LatteDelegate implements OnItemClickListener{

    private ConvenientBanner<Integer> mConvenientBanner = null;
    private  static  final ArrayList<Integer> INTEGERS = new ArrayList<>();
    private  void initBanner(){
        INTEGERS.add(R.mipmap.launcher_01);
        INTEGERS.add(R.mipmap.launcher_02);
        INTEGERS.add(R.mipmap.launcher_03);
        INTEGERS.add(R.mipmap.launcher_04);
        INTEGERS.add(R.mipmap.launcher_05);

        mConvenientBanner
                .setPages(new LauncherHolderCreator(),INTEGERS)
                .setPageIndicator(new int[]{R.drawable.dot_normal,R.drawable.dot_focus})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setOnItemClickListener(this)
                .setCanLoop(false);

    }
    @Override
    public Object setLayout() {
        mConvenientBanner = new ConvenientBanner<Integer>(getContext());
        return mConvenientBanner;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

        initBanner();
    }

    @Override
    public void onItemClick(int position) {

        //如果点击的是最后一个
        if (position == INTEGERS.size() -1){
            LattePreference.setAppFlag(ScrollLauncherTag.HAS_FIST_LAUNCHER_APP.name(),true);
            //检查用户是否已经登录

        }
    }
}
