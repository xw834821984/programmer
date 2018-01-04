package com.xw.programmer.ec.main;

import android.graphics.Color;

import com.xw.programmer.ec.main.cart.CartDelegate;
import com.xw.programmer.ec.main.compass.CompassDelegate;
import com.xw.programmer.ec.main.index.IndexDelegate;
import com.xw.programmer.ec.main.sort.SortDelegate;
import com.xw.programmer.ec.main.user.UserDelegate;
import com.xw.programmer_nucleus.delegetes.bottom.BaseBottomDelegate;
import com.xw.programmer_nucleus.delegetes.bottom.BottomItemDelegate;
import com.xw.programmer_nucleus.delegetes.bottom.BottomTabBean;
import com.xw.programmer_nucleus.delegetes.bottom.ItemBuilder;

import java.util.LinkedHashMap;

/**
 * Created by nazi on
 * date： 2018/1/4
 */

public class EcBottonDelegate extends BaseBottomDelegate {
    @Override
    public LinkedHashMap<BottomTabBean, BottomItemDelegate> setItems(ItemBuilder builder) {
        final LinkedHashMap<BottomTabBean, BottomItemDelegate> items = new LinkedHashMap<>();
        items.put(new BottomTabBean("{fa-home}", "主页"), new IndexDelegate());
        items.put(new BottomTabBean("{fa-sort}", "分类"), new SortDelegate());
        items.put(new BottomTabBean("{fa-compass}", "发现"), new CompassDelegate());
        items.put(new BottomTabBean("{fa-shopping-cart}", "购物车"), new CartDelegate());
        items.put(new BottomTabBean("{fa-user}", "我的"), new UserDelegate());
        return builder.addItem(items).build();
    }

    @Override
    public int setIndezDelegate() {
        return 0;
    }

    @Override
    public int setClickedColor() {
        //点击时显示的颜色
        return Color.parseColor("#ffff8800");
    }
}
