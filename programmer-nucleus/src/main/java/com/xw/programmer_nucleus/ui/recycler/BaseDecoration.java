package com.xw.programmer_nucleus.ui.recycler;

import android.support.annotation.ColorInt;

import com.choices.divider.DividerItemDecoration;

/**
 * Created by nazi on
 * date： 2018/1/16
 */

public class BaseDecoration extends DividerItemDecoration {


    private BaseDecoration(@ColorInt int color, int size) {

        setDividerLookup(new DividerLookupImpl(color, size));
    }

    public static BaseDecoration create(@ColorInt int color, int size) {
        return new BaseDecoration(color, size);
    }

}
