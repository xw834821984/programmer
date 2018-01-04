package com.xw.programmer.ec.main.cart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.xw.programmer.ec.R;
import com.xw.programmer_nucleus.delegetes.bottom.BottomItemDelegate;

/**
 * Created by nazi on
 * date： 2018/1/4
 * 购物车
 */

public class CartDelegate extends BottomItemDelegate{
    @Override
    public Object setLayout() {
        return R.layout.delegate_cart;
    }

    @Override
    public void onBindview(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
