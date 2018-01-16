package com.xw.programmer_nucleus.ui.banner;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

/**
 * Created by nazi on
 * date： 2018/1/15
 */

public class HolderCreator implements CBViewHolderCreator<ImagerHolder> {
    @Override
    public ImagerHolder createHolder() {
        return new ImagerHolder();
    }
}
