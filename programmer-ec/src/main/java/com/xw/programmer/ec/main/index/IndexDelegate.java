package com.xw.programmer.ec.main.index;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xw.programmer.ec.R;
import com.xw.programmer_nucleus.delegetes.bottom.BottomItemDelegate;

/**
 * Created by nazi on
 * date： 2018/1/4
 * 首页
 */

public class IndexDelegate extends BottomItemDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_index;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
